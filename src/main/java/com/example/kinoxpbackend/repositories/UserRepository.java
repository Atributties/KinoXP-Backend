package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.dto.UserDTO;
import com.example.kinoxpbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
