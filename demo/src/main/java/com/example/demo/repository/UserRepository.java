package com.example.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;


/** 
 * Spring Data JPA Repository for UserEntity. 
 * 
 * @version 1.2
 * @since 27-02-2026
*/
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>{
    Optional<UserEntity> findByCpf(String cpf);
}