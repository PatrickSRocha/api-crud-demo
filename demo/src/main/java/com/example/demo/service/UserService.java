package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.ConflictException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

/** 
 * Service responsible for handling business logic.
 * 
 * @version 1.2
 * @since 27-02-2026
*/
@Service
public class UserService{

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Finds a user by ID.
     * 
     * @param id the user identifier.
     * @return the UserEntity.
     * @throws UserNotFoundException if the user is not found.
     */
    public UserEntity findUserById(UUID id){
        UserEntity user = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found"));
        
        return user;
    }

    /**
     * Retrieves a list of users from the database.
     * 
     * @return a list of UserResponse objects. 
    */
    public List<UserResponse> getUsers(){
        return mapper.entityListToResponseList(repository.findAll(Sort.by("id").ascending()));
    }

    /**
     * Retrieves a user from the database by ID. 
     * 
     * @param id the user identifier.
     * @return the UserResponse.
    */
    public UserResponse getUser(UUID id){
        return mapper.entityToResponse(findUserById(id));
    }

    /**
     * Saves a new user in the database.
     * 
     * @param newUserDTO the UserRequest containing user data.
     * @return the UserResponse.
     * @throws UserConflictException if a user with the same ID already exists in the database.
    */
   @Transactional
    public UserResponse saveUser(UserRequest newUserRequest){
        UserEntity newUser = mapper.requestToEntity(newUserRequest);

        if (repository.findByCpf(newUser.getCpf()).isPresent()) {
            throw new ConflictException("A user already exists");
        }
        
        repository.save(newUser);

        return mapper.entityToResponse(newUser);
    }

    /**
     * Updates an existing user in the database by ID. 
     * 
     * @param id the user identifier.
     * @param updateUserDTO the UserRequest containing updated data.
     * @return the UserResponse.
    */
   @Transactional
    public UserResponse updateUser(UUID id, UserRequest updateUserDTO){
        UserEntity user = findUserById(id);
        
        user.setCpf(updateUserDTO.getCpf());
        user.setName(updateUserDTO.getName());
        user.setAge(updateUserDTO.getAge());
        
        repository.save(user);

        return mapper.entityToResponse(user);
    }

    /**
     * Deletes a user from the database.
     * 
     * @param id the user identifier.
    */
   @Transactional
    public void deleteUser(UUID id){
        repository.delete(findUserById(id));
    } 
}