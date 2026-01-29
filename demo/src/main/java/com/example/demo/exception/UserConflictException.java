package com.example.demo.exception;

public class UserConflictException extends RuntimeException{
    public UserConflictException(String message){
        super(message);
    }
}
