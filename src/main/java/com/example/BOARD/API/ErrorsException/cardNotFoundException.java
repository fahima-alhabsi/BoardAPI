package com.example.BOARD.API.ErrorsException;

public class cardNotFoundException extends RuntimeException{
    public cardNotFoundException(String message) {

        super(message);
    }
}
