package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    List<User> findByRole(String role);
}
