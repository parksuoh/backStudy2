package com.boardtest.demo.dtos;

import java.util.List;

public class GetBoardItemDto {
    private Long id;
    private String title;
    private String cont;
    private Long userId;
    private String userName;
    private List<FindCommentItemDto> comments;

    public GetBoardItemDto(Long id, String title, String cont, Long userId, String userName, List<FindCommentItemDto> comments) {
        this.id = id;
        this.title = title;
        this.cont = cont;
        this.userId = userId;
        this.userName = userName;
        this.comments = comments;
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

    public List<FindCommentItemDto> getComments() {
        return comments;
    }

    public void setComments(List<FindCommentItemDto> comments) {
        this.comments = comments;
    }
}
