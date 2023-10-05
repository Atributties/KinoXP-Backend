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
public class UserRESTController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println(user.toString());
        System.out.println(user.getPhoneNumber());
        User createdUser = userService.save(user);
        if (createdUser == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            System.out.println(createdUser.toString());
            System.out.println(createdUser.getPhoneNumber());
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }
    }


    @PostMapping("/user/login")
    public ResponseEntity<User> userLogin(@RequestBody User loginDetails) {
        User user = userService.findByEmail(loginDetails.getEmail());
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
    public ResponseEntity<User> getUserById(int id) {
        Optional<User> user = Optional.ofNullable(userService.findById(id));
        if(user.isPresent()) {
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
