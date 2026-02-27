package com.example.demo.error;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import io.swagger.v3.oas.annotations.media.Schema;

/** 
 * Standard error response returned by the API.
 * 
 * @version 1.1
 * @since 11-02-2026

*/
@Schema(name="Error Response" ,description="Standard error response returned by the API")
public class ErrorResponse{
    
    @Schema(description="Date of the request", example="2026-02-27T20:27:08.554+00:00")
    private OffsetDateTime timestamp;
    
    @Schema(description="HTTP status code", example="404", type="integer")
    private int status;

    @Schema(description="Type of error", example="Not Found")
    private String error;

    @Schema(description="Error message", example="User not found")
    private String message;
    
    @Schema(description="Request path", example="/user/2026-02-27T15:23:50.4363818")
    private String path;

    public ErrorResponse(){
    }

    public ErrorResponse(int status, String error, String message, String path){
        this.timestamp = OffsetDateTime.now(ZoneOffset.UTC);
        this.status = status;
        this.error = error;
        this.message =  message;
        this.path = path;
    }

    public OffsetDateTime getTimestamp(){
        return timestamp;
    }

    public int getStatus(){
        return status;
    }
    
    public String getError(){
        return error;
    }

    public String getMessage(){
        return message;
    }

    public String getPath(){
        return path;
    }
}