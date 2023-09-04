package com.example.doan1.repository;

import com.example.doan1.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findByUserEmail(String userEmail);
    UserEntity findFirstByUserEmail(String userEmail);
}
