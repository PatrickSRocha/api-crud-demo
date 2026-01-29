package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

@Repository
public class UserRepository {
    
    private final List<UserEntity> banco = new ArrayList<>();
    
    public UserEntity find(String id){
        for (UserEntity user : banco) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void save(UserEntity newUser){
        banco.add(newUser);         
    }

    public void exclude(UserEntity user){
        banco.remove(user);
    }
    
    public List<UserEntity> getUsers(){
       return List.copyOf(banco);
    }
}
