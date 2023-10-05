package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.entities.User;
import com.example.kinoxpbackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }
}
