package com.boardtest.demo.dtos;

public class DeleteBoardDto {
    private Long boardId;
    private Long userId;

    public DeleteBoardDto(Long boardId, Long userId) {
        this.boardId = boardId;
        this.userId = userId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
