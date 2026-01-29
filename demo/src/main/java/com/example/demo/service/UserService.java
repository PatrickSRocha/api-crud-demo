package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserConflictException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserRequestDTO;
import com.example.demo.model.UserResponseDTO;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UserResponseDTO> getUsers(){
        return mapper.entityListToResponseList(repository.getUsers());
    }

    public UserResponseDTO getUser(String id){
        
        UserEntity user = repository.find(id);

        if(user == null){
            throw new UserNotFoundException("User não encontrado.");
        }
        
        return mapper.entityToResponse(user);
    }

    public UserResponseDTO saveUser(UserRequestDTO newUserDTO){
        
        UserEntity newUser = mapper.requestToEntity(newUserDTO);

        if (repository.find(newUser.getId()) != null) {
            throw new UserConflictException("User já existe.");
        }
        
        repository.save(newUser);

        return mapper.entityToResponse(newUser);
    }

    public UserResponseDTO updateUser(String id, UserRequestDTO updateUserDTO){
        
        if (!id.equals(updateUserDTO.getId())) {
            throw new UserConflictException("O id da URL e do corpo da requisição precisam ser iguais.");
        }

        UserEntity user = repository.find(updateUserDTO.getId());

        if (user == null) {
            throw new UserNotFoundException("User não encontrado.");
        }

        user.setName(updateUserDTO.getName());
        user.setAge(updateUserDTO.getAge());
        
        return mapper.entityToResponse(user);
    }

    public void deleteUser(String id){
        
        UserEntity user = repository.find(id);
        
        if(user != null){
            repository.exclude(user);
        }
        else{
             throw new UserNotFoundException("User não encontrado.");
        }
    } 
}
