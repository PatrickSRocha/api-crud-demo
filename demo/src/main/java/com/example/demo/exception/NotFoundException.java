package com.example.demo.exception;

/** 
 * Exception thrown when a user is not found.
 * 
 * @version 1.1
 * @since 11-02-2026
*/
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}