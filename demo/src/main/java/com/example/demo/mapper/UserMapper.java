package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.UserEntity;

/** 
 * Mapper responsible for converting between UserEntity and DTO objects.
 * 
 * @version 1.2
 * @since 27-02-2026
*/
@Component
public class UserMapper{
    
    /**
     * Converts a UserRequest to a UserEntity.
     * 
     * @param userDTO the UserRequest to be converted.
     * @return the UserEntity.
     */
    public UserEntity requestToEntity(UserRequest userRequest){
        return new UserEntity(
            userRequest.getCpf(),
            userRequest.getName(), 
            userRequest.getAge());
    }

    /**
     * Converts a UserEntity to a UserResponse.
     * 
     * @param user the UserEntity to be converted.
     * @return the UserResponse.
     */
    public UserResponse entityToResponse(UserEntity userEntity){
        return new UserResponse( 
            userEntity.getId().toString(),
            userEntity.getCpf(),
            userEntity.getName(),
            userEntity.getAge()
        );
    }

    /**
     * Converts a list of UserEntity objects to a list of UserResponse objects. 
     * 
     * @param users the list of UserEntity objects.
     * @return a list of UserResponse objects. 
     */
    public List<UserResponse> entityListToResponseList(List<UserEntity> users){
        List<UserResponse> listUserResponse = new ArrayList<>();

        for (UserEntity user : users){
            UserResponse userDTO = entityToResponse(user);
            listUserResponse.add(userDTO);
        }

        return listUserResponse;
    }
}