package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.UserDTO;
import com.example.kinoxpbackend.entities.User;
import com.example.kinoxpbackend.service.LoginSessionService;
import com.example.kinoxpbackend.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class LoginSessionRESTController {


    @Autowired
    private LoginSessionService loginSessionService;

    @GetMapping("/session/user")
    public ResponseEntity<UserDTO> getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Retrieve the user object from the session (adjust the attribute name as needed)
            String email = (String) session.getAttribute("username");
            Optional<User> user = loginSessionService.findByEmail(email);

            if (user.isPresent()) {
                UserDTO userDTO = new UserDTO(user.get()); // Include ReservationDTO
                return new ResponseEntity<>(userDTO, HttpStatus.OK);
            }
        }

        // If no user is found in the session or there's no active session, return an error response
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }


    @PostMapping(value = "/session/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody User user, HttpServletRequest request) {
        User user1 = loginSessionService.validateUser(user.getEmail(), user.getPassword());
        if (user1 != null) {
            HttpSession session = request.getSession();
            // Store data in the session
            session.setAttribute("username", user1.getEmail());
            System.out.println("Username: " + user1.getEmail());
            String username = (String) session.getAttribute("username");
            System.out.println("Session name: " + username);

            return ResponseEntity.ok("Login successful");
        } else {
            System.out.println("Invalid credentials");
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    // Implement a logout endpoint if needed
    @GetMapping("/session/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Clear any session attributes or data
            session.invalidate(); // Invalidate the session (log out the user)

            // Clear session-related cookies
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("JSESSIONID")) {
                        cookie.setMaxAge(0); // Expire the session-related cookie immediately
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }

            System.out.println("Logout of session successful");

            // Return a response to the client
            return ResponseEntity.ok("Logout successful");
        } else {
            System.out.println("No active session to log out from");
            // If there's no active session, return an error response
            return ResponseEntity.badRequest().body("No active session to log out from");
        }
    }





}
