package com.boardtest.demo.dtos;

import com.querydsl.core.annotations.QueryProjection;

public class FindBoardItemDto {
    private Long id;
    private String title;
    private String cont;
    private Long userId;
    private String userName;

    @QueryProjection
    public FindBoardItemDto(Long id, String title, String cont, Long userId, String userName) {
        this.id = id;
        this.title = title;
        this.cont = cont;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
