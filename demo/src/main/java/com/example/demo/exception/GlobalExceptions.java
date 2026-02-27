package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.error.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

/** 
 * Global exception handler for the application.
 * 
 * @version 1.2
 * @since 27-02-2026
*/
@ControllerAdvice
public class GlobalExceptions{
    
    /**
     * Handles cases by unknown server error.
     * 
     * @param InternalError the Exception thrown by unknown error.
     * @param request the current HTTP request.
     * @return HTTP 500 (INTERNAL SERVER ERROR) with error details in the response body.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> InternalError(Exception InternalError, HttpServletRequest request){
        ErrorResponse error =  new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
            "Unknown internal server error",
            request.getRequestURI());

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(error);
    }

    /**
     * Handles validation errors triggered by invalid request data.
     * 
     * @param badRequest the MethodArgumentNotValidException thrown by the validation process.
     * @param request the current HTTP request. 
     * @return HTTP 400 (BAD REQUEST) with error details in the response body.
    */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validError(MethodArgumentNotValidException badRequest, HttpServletRequest request){
        String message = badRequest.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error -> error.getDefaultMessage())
            .findFirst()
            .orElse("Validation error");

        ErrorResponse error =  new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            message,
            request.getRequestURI());

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error);
    }

    /**
     * Handles cases where a user is not found.
     * 
     * @param notFound the UserNotFoundException thrown when the user does not exist.
     * @param request the current HTTP request. 
     * @return HTTP 404 (NOT FOUND) with error details in the response body.
    */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFound(NotFoundException notFound, HttpServletRequest request){
        ErrorResponse error =  new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            notFound.getMessage(),
            request.getRequestURI());

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(error);
    }

    /**
     * Handles conflicts between the user ID in the URL and request body. 
     * 
     * @param conflict the UserConflictException thrown when IDs do not match.
     * @param request the current HTTP request.  
     * @return HTTP 409 (CONFLICT) with error details in the response body.
     */
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> userConflict(ConflictException conflict, HttpServletRequest request){
        ErrorResponse error = new ErrorResponse( 
            HttpStatus.CONFLICT.value(),
            HttpStatus.CONFLICT.getReasonPhrase(),
            conflict.getMessage(),
            request.getRequestURI());
        
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(error);
    }
}