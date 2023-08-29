package com.boardtest.demo.controllers;

import com.boardtest.demo.applications.CreateCommentService;
import com.boardtest.demo.applications.DeleteCommentService;
import com.boardtest.demo.dtos.CreateCommentDto;
import com.boardtest.demo.dtos.DeleteCommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CreateCommentService createCommentService;
    private final DeleteCommentService deleteCommentService;

    public CommentController(CreateCommentService createCommentService, DeleteCommentService deleteCommentService) {
        this.createCommentService = createCommentService;
        this.deleteCommentService = deleteCommentService;
    }

    // TODO: 댓글 입력
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createComment(@RequestBody CreateCommentDto createCommentDto ) {
        createCommentService
                .createComment(createCommentDto.getBoardId(), createCommentDto.getUserId(), createCommentDto.getCont());

        return "created";
    }

    // TODO: 댓글 삭제
    @DeleteMapping
    public String deleteComment(@RequestBody DeleteCommentDto deleteCommentDto){
        deleteCommentService.deleteComment(deleteCommentDto.getCommentId(), deleteCommentDto.getUserId());

        return "deleted";
    }
}
