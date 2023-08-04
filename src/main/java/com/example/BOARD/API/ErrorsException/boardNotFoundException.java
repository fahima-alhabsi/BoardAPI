package com.example.BOARD.API.ErrorsException;

public class boardNotFoundException extends RuntimeException{
    public boardNotFoundException(String message)
    {
        super(message);
    }
}
