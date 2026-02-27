package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/** 
 * Data transfer object used to represent user response data.
 * 
 * @version 1.2
 * @since 27-02-2026
*/
@Schema(name="User Response", description="Data transfer object used to represent user response data")
public class UserResponse{
    
    @Schema(description="User id", example="2026-02-27T15:23:50.4363818")
    private String id;

    @Schema(description="User cpf", example="12345678910")
    private String cpf;

    @Schema(description="User name", example="Ronaldo")
    private String name;
    
    @Schema(description="User age", example="49")
    private int age;

    public UserResponse(){
    }

    public UserResponse(String id, String cpf, String name, int age){
        this.id = id;
        this.cpf = cpf;
        this.name =  name;
        this.age = age;
    }

    public String getId(){
        return this.id;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}