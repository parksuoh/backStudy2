package com.boardtest.demo.applications;

import com.boardtest.demo.models.Board;
import com.boardtest.demo.models.Comment;
import com.boardtest.demo.models.User;
import com.boardtest.demo.repositories.BoardRepository;
import com.boardtest.demo.repositories.CommentRepository;
import com.boardtest.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateCommentService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public CreateCommentService(UserRepository userRepository, BoardRepository boardRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }


    public void createComment(Long boardId, Long userId, String cont) {
        Board board = boardRepository.findById(boardId).get();
        User user = userRepository.findById(userId).get();

        Comment comment = new Comment(cont, user, board);
        commentRepository.save(comment);

    }
}
