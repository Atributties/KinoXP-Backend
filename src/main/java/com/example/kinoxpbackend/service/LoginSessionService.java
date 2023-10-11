package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.dto.UserDTO;
import com.example.kinoxpbackend.entities.User;
import com.example.kinoxpbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginSessionService {

    private final UserRepository userRepository;

    @Autowired
    public LoginSessionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public User validateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
}
