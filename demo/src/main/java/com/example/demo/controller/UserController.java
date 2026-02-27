package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.service.UserService;
import com.example.demo.swagger.ConflictResponse;
import com.example.demo.swagger.CreatedResponse;
import com.example.demo.swagger.InternalServerError;
import com.example.demo.swagger.ListResponse;
import com.example.demo.swagger.NotFoundResponse;
import com.example.demo.swagger.SuccessResponse;
import com.example.demo.swagger.ValidationErrorResponse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



/** 
 * REST Controller used for HTTP requests and responses.
 * 
 * @version 1.2
 * @since 27-02-2026
*/
@OpenAPIDefinition(
    info=@Info(
        title = "USER API", 
        version = "1.1", 
        description = "This API was developed to manage user data in a database",
        contact = @Contact(
            name = "Patrick Rocha",
            url= "https://www.linkedin.com/in/patrick-rocha-149244289/")),
    servers = {@Server(url = "http://localhost:8080", description = "Local server")}
)
@Tag(name="USER CONTROLLER", description="REST Controller used for HTTP requests and responses")
@RestController
@RequestMapping(value="/user", produces="application/json")
@Validated
public class UserController{
    
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    /**
     * Retrieves all users saved in the database.
     * 
     * @return HTTP 200 (OK) and a list of user objects.
     */
    @Operation(summary="Retrieve all users", description="Retrieves all users saved in the database")
    @ListResponse
    @GetMapping
    public ResponseEntity<List<UserResponse>> allUsers(){
        return ResponseEntity
            .ok(service.getUsers());
    }
    
    /**
     * Retrieves an existing user by ID.
     * 
     * @param id the user identifier.
     * @return HTTP 200 (OK) and the user data.
     */
    @Operation(summary="Retrieve a user", description="Retrieves an existing user by ID")
    @SuccessResponse
    @NotFoundResponse
    @InternalServerError
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(
        @Parameter(description="Unique identifier of the user", example="2026-02-27T15:23:50.4363818", required=true) @PathVariable UUID id){
        return ResponseEntity
            .ok(service.getUser(id));
    }

    /**
     * Saves a new user in the database.
     * 
     * @param userDTO the user data transfer object.
     * @return HTTP 201 (CREATED) and the saved user.
     */
    @Operation(summary="Create a user", description="Saves a new user in the database")
    @CreatedResponse
    @ValidationErrorResponse
    @ConflictResponse
    @InternalServerError
    @PostMapping(consumes="application/json")
    public ResponseEntity<UserResponse> createUser(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description="User data to be created", required=true) @RequestBody @Valid UserRequest userDTO){
        UserResponse userSaved = service.saveUser(userDTO);
        
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header("Location", "/user/" + userSaved.getId())
            .body(userSaved);
    }

    /**
     * Updates an existing user by ID.
     * 
     * @param id the user identifier.
     * @param userDTO the user data transfer object.
     * @return HTTP 200 (OK) and the updated user data.
     */
    @Operation(summary="Update an existing user", description="Updates an existing user by ID")
    @SuccessResponse
    @NotFoundResponse
    @ValidationErrorResponse
    @InternalServerError
    @PutMapping(value="/{id}", consumes="application/json")
    public ResponseEntity<UserResponse> updateUser(
        @Parameter(description="Unique identifier of the user", example="2026-02-27T15:23:50.4363818", required=true) @PathVariable UUID id, 
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description="User data to be updated", required=true) @RequestBody @Valid UserRequest newUserDTO){
        return ResponseEntity
            .ok(service.updateUser(id, newUserDTO));
    }

    /**
     * Deletes an existing user by ID.
     * 
     * @param id the user identifier.
     * @return HTTP 204 (NO CONTENT).
     */
    @Operation(summary="Delete a user", description="Deletes an existing user by ID")
    @NotFoundResponse
    @InternalServerError
    @ApiResponse(responseCode="204", description="No Content")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
        @Parameter(description="Unique identifier of the user", example="2026-02-27T15:23:50.4363818", required=true) @PathVariable UUID id){
        service.deleteUser(id);
        return ResponseEntity
            .noContent()
            .build();       
    }
}