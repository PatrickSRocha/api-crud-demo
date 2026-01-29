package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserRequestDTO;
import com.example.demo.model.UserResponseDTO;

@Component
public class UserMapper {
    
    public UserResponseDTO entityToResponse(UserEntity user){
        
        return new UserResponseDTO( 
            user.getId(),
            user.getName(),
            user.getAge()
        );
    }

    public UserEntity requestToEntity(UserRequestDTO userDTO){
        
        return new UserEntity(
            userDTO.getId(),
            userDTO.getName(),
            userDTO.getAge()
        );
    }

    public List<UserResponseDTO> entityListToResponseList(List<UserEntity> users) {

        List<UserResponseDTO> listDTO = new ArrayList<>();

        for (UserEntity user : users) {
            UserResponseDTO userDTO = entityToResponse(user);
            listDTO.add(userDTO);
        }

        return  listDTO;
    }
}

