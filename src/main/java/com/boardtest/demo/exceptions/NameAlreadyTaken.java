package com.boardtest.demo.exceptions;

public class NameAlreadyTaken extends RuntimeException {

    public NameAlreadyTaken(String name) {
        super("Name has already been taken: " + name);
    }
}
