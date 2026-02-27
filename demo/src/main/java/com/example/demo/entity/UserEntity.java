package com.example.demo.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

/** 
 * Entity used for persisting user data in the database.
 * 
 * @version 1.2
 * @since 27-02-2026
*/
@Entity
@Table(name="users")
public class UserEntity{
    
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column(name="user_cpf", nullable=false, unique=true, length=11)
    private String cpf;

    @Column(name="user_name", nullable=false, length=50)
    private String name;
    
    @Min(1)
    @Max(120)
    @Column(name="user_age", nullable=false)
    private int age;

    protected UserEntity(){
    }

    public UserEntity(String cpf, String name, int age){
        this.cpf = cpf;
        this.name =  name;
        this.age = age;
    }

    public UUID getId(){
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
        
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge (int age){
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserEntity other = (UserEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}