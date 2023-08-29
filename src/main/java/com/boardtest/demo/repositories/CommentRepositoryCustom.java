package com.boardtest.demo.repositories;

import com.boardtest.demo.dtos.FindCommentItemDto;

import java.util.List;

public interface CommentRepositoryCustom {

    List<FindCommentItemDto> findCommentItems(Long id);
}
