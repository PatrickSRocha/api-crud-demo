package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequestDTO;
import com.example.demo.model.UserResponseDTO;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
@Validated
public class UserController {
    
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    //Retorna todos os users salvos.
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> allUsers(){
        return ResponseEntity
                    .ok(service.getUsers());
    }
    
    //Retorna os dados do user salvo buscando por id.
    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable String id) {
        return ResponseEntity
            .ok(service.getUser(id));
    }

    //Salva os dados de um novo user.
    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userDTO){
        
        UserResponseDTO user = service.saveUser(userDTO);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header("Location", "/api/users/" + user.getId())
            .body(user);
    }

    //Atualiza todos os dados do user salvo buscando por id.
    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> updateUsuario(@PathVariable String id, @RequestBody @Valid UserRequestDTO newUserDTO){
        
        UserResponseDTO user = service.updateUser(id, newUserDTO);
            
        return ResponseEntity
                .ok(user);
    }

    //Deleta os dados do user salvo buscando por id.
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        service.deleteUser(id);
        
        return ResponseEntity
            .noContent()
            .build();       
    }
}
