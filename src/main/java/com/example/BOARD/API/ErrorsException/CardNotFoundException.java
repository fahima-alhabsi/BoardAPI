package com.example.BOARD.API.ErrorsException;

public class CardNotFoundException  extends RuntimeException{
    public CardNotFoundException(String message) {
        super(message);
    }
}
