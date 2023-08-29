package com.boardtest.demo.exceptions;

public class BoardNotExist extends RuntimeException {

    public BoardNotExist() {
        super("Board Not Exist ");
    }
}
