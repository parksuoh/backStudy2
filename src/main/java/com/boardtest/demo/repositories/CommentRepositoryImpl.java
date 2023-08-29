package com.boardtest.demo.repositories;

import com.boardtest.demo.dtos.FindBoardItemDto;
import com.boardtest.demo.dtos.FindCommentItemDto;
import com.boardtest.demo.dtos.QFindBoardItemDto;
import com.boardtest.demo.dtos.QFindCommentItemDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.boardtest.demo.models.QUser.user;
import static com.boardtest.demo.models.QComment.comment;

public class CommentRepositoryImpl implements  CommentRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    public CommentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<FindCommentItemDto> findCommentItems(Long id) {

        List<FindCommentItemDto> results = queryFactory
                .select(new QFindCommentItemDto(comment.id, comment.cont, user.id, user.name))
                .from(comment)
                .leftJoin(comment.user, user)
                .where(comment.board.id.eq(id))
                .fetch();

        return results;
    }
}
