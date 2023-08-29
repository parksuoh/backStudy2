package com.boardtest.demo.repositories;

import com.boardtest.demo.dtos.FindBoardItemDto;
import com.boardtest.demo.dtos.QFindBoardItemDto;
import com.boardtest.demo.dtos.QSearchBoardDto;
import com.boardtest.demo.dtos.SearchBoardDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.boardtest.demo.models.QUser.user;
import static com.boardtest.demo.models.QBoard.board;

public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    public BoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public FindBoardItemDto findBoardItem(Long id) {

        FindBoardItemDto resulte = queryFactory
                .select(new QFindBoardItemDto(board.id, board.title, board.cont, user.id, user.name))
                .from(board)
                .leftJoin(board.user, user)
                .where(board.id.eq(id))
                .fetchOne();

        return resulte;
    }

    @Override
    public Page<SearchBoardDto> searchPageBoard(Pageable pageable) {

        List<SearchBoardDto> contents = queryFactory
                .select(new QSearchBoardDto(board.id, board.title, user.name))
                .from(board)
                .leftJoin(board.user, user)
                .orderBy(board.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .selectFrom(board)
                .fetchCount();

        return new PageImpl<>(contents, pageable, total);
    }
}
