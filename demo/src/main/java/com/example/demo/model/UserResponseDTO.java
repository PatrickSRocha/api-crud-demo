package com.example.demo.model;

public class UserResponseDTO {
    
    private String id;
    private String name;
    private Integer age;

    public UserResponseDTO(){
    }

    public UserResponseDTO(String id, String name, Integer age){
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
}
