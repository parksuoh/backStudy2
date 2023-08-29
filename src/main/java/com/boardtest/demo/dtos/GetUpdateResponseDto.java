package com.boardtest.demo.dtos;

public class GetUpdateResponseDto {

    private Long id;
    private String title;
    private String cont;

    public GetUpdateResponseDto(Long id, String title, String cont) {
        this.id = id;
        this.title = title;
        this.cont = cont;
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
}
