package com.example.kinoxpbackend.exceptions;

public class TheaterNotFoundException extends RuntimeException{
    public TheaterNotFoundException(String message){
        super(message);
    }
}
