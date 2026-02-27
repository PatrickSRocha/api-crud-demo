package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/** 
 * Data transfer object used to receive user request data.
 * 
 * @version 1.2
 * @since 27-02-2026
*/
@Schema(name="User Request", description="Data transfer object used to receive user request data")
public class UserRequest{

    @Schema(description="User CPF", example="12345678910")
    @NotBlank(message="The CPF is required")
    @Size(min=11, max=11, message="The CPF must have 11 characters")
    private String cpf;

    @Schema(description="User name", example="Ronaldo")
    @NotBlank(message="The name is required")
    @Size(max=50, message="The name must be less than 50 characters")
    private String name;
    
    @Schema(description="User age", example="49")
    @NotNull(message="The age is required")
    @Min(value=1, message="The age must be greater than 0")
    @Max(value=120, message="The age must be less than or equal to 120")
    private int age;

    public UserRequest(){
    }

    public UserRequest(String cpf, String name, int age){
        this.cpf = cpf;
        this.name =  name;
        this.age = age;
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
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge (int age){
        this.age = age;
    }
}