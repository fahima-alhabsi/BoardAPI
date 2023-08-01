package com.example.BOARD.API.ErrorsException;

public class BoardNotFoundException  extends RuntimeException{
    public BoardNotFoundException(String message) {
        super(message);
    }
}
