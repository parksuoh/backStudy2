package com.boardtest.demo.applications;

import com.boardtest.demo.dtos.FindBoardItemDto;
import com.boardtest.demo.dtos.FindCommentItemDto;
import com.boardtest.demo.dtos.GetBoardItemDto;
import com.boardtest.demo.repositories.BoardRepository;
import com.boardtest.demo.repositories.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GetBoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public GetBoardService(BoardRepository boardRepository, CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }


    public GetBoardItemDto getBoard(Long id) {
        FindBoardItemDto board = boardRepository.findBoardItem(id);
        List<FindCommentItemDto> comments = commentRepository.findCommentItems(id);

        return new GetBoardItemDto(board.getId(), board.getTitle(), board.getCont(), board.getUserId(), board.getUserName(), comments);
    }
}
