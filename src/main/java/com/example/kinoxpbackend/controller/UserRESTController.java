package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.entities.User;
import com.example.kinoxpbackend.enums.Roles;
import com.example.kinoxpbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/users")
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

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletRequest request) {
        // Validate the user credentials here (e.g., check against a database)
        // For simplicity, let's assume you have a UserService to perform user validation
        User user1 = userService.validateUser(user.getEmail(), user.getPassword());
        if (user1 != null) {
            HttpSession session = request.getSession();
            // Store data in the session
            session.setAttribute("username", user.getEmail());
            System.out.println("Username: " + user.getEmail());
            String username = (String) session.getAttribute("username");
            System.out.println("Session name: " + username);

            return ResponseEntity.ok("Login successful");
        } else {
            System.out.println("Invalid credentials");
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    // Implement a logout endpoint if needed

    @GetMapping("/user/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Get the existing session if it exists

        if (session != null) {
            session.invalidate(); // Invalidate the session (log out the user)
            System.out.println("Logout of session succes");
            return ResponseEntity.ok("Logout successful");
        } else {
            System.out.println("Logout not good");
            // If there's no active session, you can return an error response
            return ResponseEntity.badRequest().body("No active session to log out from");
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
