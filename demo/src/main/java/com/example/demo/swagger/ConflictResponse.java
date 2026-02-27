package com.example.demo.swagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.example.demo.error.ErrorResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/** 
 * Standardized Swagger documentation for HTTP 409 Conflict responses with standard ErrorResponse.
 * 
 * @version 1.0
 * @since 27-02-2026
*/
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "409",
    description = "Conflict",
    content = @Content(mediaType = "application/json", 
    schema = @Schema(implementation = ErrorResponse.class),
    examples = {@ExampleObject(value = 
        """
        {
            "timestamp":"2026-02-27T20:27:08.554+00:00",
            "status":409,
            "error":"Conflict",
            "message":"A user already exists",
            "path":"/user"
        }
        """)}))
public @interface ConflictResponse {
}