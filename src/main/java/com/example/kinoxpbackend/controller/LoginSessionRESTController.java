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
            // Retrieve the user's id from the session
            Integer userId = (Integer) session.getAttribute("userId");
            System.out.println("user from session: " + userId.intValue());

            if (userId != null) {
                Optional<User> user = loginSessionService.findById(userId);
                System.out.println("user from session: " + userId.intValue());
                System.out.println("Id from user: " + user.get().getId());
                System.out.println("reservation: " + user.get().getReservation());

                if (user.isPresent()) {
                    UserDTO userDTO = new UserDTO(user.get()); // Include ReservationDTO
                    return new ResponseEntity<>(userDTO, HttpStatus.OK);
                }
            }
        }

        // If no user is found in the session or there's no active session, return an error response
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }


    @PostMapping(value = "/session/login")
    public ResponseEntity<UserDTO> login(@RequestBody User user) {
        User authenticatedUser = loginSessionService.validateUser(user.getEmail(), user.getPassword());

        if (authenticatedUser != null) {
            UserDTO userDTO = new UserDTO(authenticatedUser); // Include ReservationDTO
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
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
