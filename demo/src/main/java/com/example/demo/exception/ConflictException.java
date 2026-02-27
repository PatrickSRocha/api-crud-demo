package com.example.demo.exception;

/** 
 * Exception thrown when there is a conflict between the user ID in the URL and request body. 
 * 
 * @version 1.1
 * @since 11-02-2026
*/
public class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}