package com.boardtest.demo.dtos;

public class UpdateBoardRequestDto {

    private String title;
    private String cont;
    private Long userId;

    public UpdateBoardRequestDto(String title, String cont, Long userId) {
        this.title = title;
        this.cont = cont;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
