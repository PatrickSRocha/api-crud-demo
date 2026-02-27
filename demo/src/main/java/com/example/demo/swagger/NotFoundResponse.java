package com.example.demo.swagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.example.demo.error.ErrorResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/** 
 * Standardized Swagger documentation for HTTP 404 Not Found responses with standard ErrorResponse.
 * 
 * @version 1.0
 * @since 27-02-2026
*/
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "404",
    description = "Not Found",
    content = @Content(mediaType = "application/json", 
    schema = @Schema(implementation = ErrorResponse.class)))
public @interface NotFoundResponse{
}