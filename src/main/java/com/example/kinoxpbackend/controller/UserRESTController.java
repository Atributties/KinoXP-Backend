package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.ReservationDTO;
import com.example.kinoxpbackend.dto.UserDTO;
import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.entities.Reservation;
import com.example.kinoxpbackend.entities.User;
import com.example.kinoxpbackend.enums.Roles;
import com.example.kinoxpbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            UserDTO userDTO = new UserDTO(user.get()); // Include ReservationDTO
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
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

    @PutMapping("/user/{id}")
    public ResponseEntity<User> putUser(@PathVariable int id, @RequestBody User user) {
        Optional<User> orgUser = userService.findById(id);
        if(orgUser.isPresent()) {
            user.setId(id);
            userService.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        Optional<User> orgUser = userService.findById(id);
        if(orgUser.isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.ok("User deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }




    @GetMapping("/user/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findByEmail(email);

        if (user.isPresent()) {
            UserDTO userDTO = new UserDTO(user.get()); // Include ReservationDTO
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
