package com.example.demo.swagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.example.demo.dto.UserResponse;

import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/** 
 * Standardized Swagger documentation for HTTP 201 Created responses.
 * 
 * @version 1.0
 * @since 27-02-2026
*/
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "201",
    description = "Created",
    content = @Content(mediaType = "application/json", 
    schema = @Schema(implementation = UserResponse.class)),
    headers = {@Header(
        name ="Location",
        description = "URI of the newly created user",
        schema = @Schema(
            type ="string",
            example = "/user"))})
public @interface CreatedResponse{
}