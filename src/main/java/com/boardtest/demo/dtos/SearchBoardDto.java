package com.boardtest.demo.dtos;


import com.querydsl.core.annotations.QueryProjection;

public class SearchBoardDto {

    private Long id;
    private String title;
    private String userName;

    @QueryProjection
    public SearchBoardDto(Long id, String title, String userName) {
        this.id = id;
        this.title = title;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
