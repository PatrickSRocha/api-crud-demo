package com.example.demo.swagger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.example.demo.dto.UserResponse;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/** 
 * Standardized Swagger documentation for HTTP 200 Ok responses.
 * 
 * @version 1.0
 * @since 27-02-2026
*/
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "200",
    description = "OK",
    content = @Content(mediaType = "application/json", 
    array = @ArraySchema(schema = @Schema(implementation = UserResponse.class))))
public @interface ListResponse{
}