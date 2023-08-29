package com.boardtest.demo.dtos;

public class CreateCommentDto {

    private Long boardId;
    private Long userId;
    private String cont;

    public CreateCommentDto(Long boardId, Long userId, String cont) {
        this.boardId = boardId;
        this.userId = userId;
        this.cont = cont;
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

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
}
