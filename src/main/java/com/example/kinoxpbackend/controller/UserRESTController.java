package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.entities.User;
import com.example.kinoxpbackend.enums.Roles;
import com.example.kinoxpbackend.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserRESTController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.save(user);
        if (createdUser == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }
    }


    @GetMapping("/user/email/{email}")
    public ResponseEntity<User> getUserByEmail(@RequestBody String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = Optional.ofNullable(userService.findById(id));
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/role/{email}")
    public ResponseEntity<Roles> getUserRole(@PathVariable String email) {
        User user = userService.findByEmail(email);

        if (user != null) {
            Roles role = user.getRole();
            return new ResponseEntity<>(role, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
