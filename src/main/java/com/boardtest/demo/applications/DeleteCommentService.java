package com.boardtest.demo.applications;

import com.boardtest.demo.exceptions.NameNotExist;
import com.boardtest.demo.models.Comment;
import com.boardtest.demo.repositories.CommentRepository;
import com.boardtest.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteCommentService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public DeleteCommentService(UserRepository userRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public void deleteComment(Long commentId, Long userId) {
        Comment comment = commentRepository.findById(commentId).get();

        if(comment.user().id() != userId ) {
            throw new NameNotExist();
        }

        commentRepository.delete(comment);
    }
}
