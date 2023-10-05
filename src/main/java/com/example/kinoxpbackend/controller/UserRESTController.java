package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.entities.User;
import com.example.kinoxpbackend.enums.Roles;
import com.example.kinoxpbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserRESTController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody User loginDetails) {
        User user = userService.findByUsername(loginDetails.getUsername());
        if (user != null) {
            if (user.getPassword().equals(loginDetails.getPassword())) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.save(user);
        if (createdUser != null) {
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByUserName(@RequestBody String userName) {
        User user = userService.findByUsername(userName);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(int id) {
        Optional<User> user = Optional.ofNullable(userService.findById(id));
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/role/{userName}")
    public ResponseEntity<Roles> getUserRole(@PathVariable String userName) {
        User user = userService.findByUsername(userName);

        if (user != null) {
            Roles role = user.getRole();
            return new ResponseEntity<>(role, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
