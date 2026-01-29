package com.example.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
    
    @NotBlank(message = "O id é obrigatório")
    private String id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 50, message = "O nome não pode ter mais de 50 caracteres")
    private String name;
    
    @NotNull(message = "A idade é obrigatória")
    @Min(value = 1, message = "A idade precisa ser maior que 0 anos")
    @Max(value = 120, message = "A idade precisa ser menor que 120 anos")
    private Integer age;

    public UserRequestDTO(){
    }

    public UserRequestDTO(String id, String name, Integer age){
        this.id = id;
        this.name =  name;
        this.age = age;
    }

    public  String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Integer getAge(){
        return this.age;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void setAge (Integer age){
        this.age = age;
    }
}
