package com.boardtest.demo.dtos;

import com.querydsl.core.annotations.QueryProjection;

public class FindCommentItemDto {
    private Long id;
    private String cont;
    private Long userId;
    private String userName;

    @QueryProjection
    public FindCommentItemDto(Long id, String cont, Long userId, String userName) {
        this.id = id;
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
