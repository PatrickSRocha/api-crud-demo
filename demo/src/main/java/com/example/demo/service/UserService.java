package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserConflictException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
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
        return mapper.entityListToResponseList(repository.findAll(Sort.by("id").ascending()));
    }

    public UserResponseDTO getUser(String id){
        
        UserEntity user = repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User não encontrado."));
        
        return mapper.entityToResponse(user);
    }

    public UserResponseDTO saveUser(UserRequestDTO newUserDTO){
        
        UserEntity newUser = mapper.requestToEntity(newUserDTO);

        if (repository.existsById(newUser.getId())) {
            throw new UserConflictException("User já existe.");
        }
        
        repository.save(newUser);

        return mapper.entityToResponse(newUser);
    }

    public UserResponseDTO updateUser(String id, UserRequestDTO updateUserDTO){
        
        if (!id.equals(updateUserDTO.getId())) {
            throw new UserConflictException("O id da URL e do corpo da requisição precisam ser iguais.");
        }

        UserEntity user = repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User não encontrado."));
        
        user.setName(updateUserDTO.getName());
        user.setAge(updateUserDTO.getAge());

        repository.save(user);
        
        return mapper.entityToResponse(user);
    }

    public void deleteUser(String id){
        
        UserEntity user = repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User não encontrado."));
        
            repository.delete(user);
    } 
}
