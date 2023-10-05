package com.example.kinoxpbackend.controller;


import com.example.kinoxpbackend.entities.User;
import com.example.kinoxpbackend.enums.Roles;
import com.example.kinoxpbackend.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRESTControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserRESTController userRESTController;

    @BeforeAll
    public void beforeAll() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void beforeEach() {
        User user = new User();
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testGetUserByUsername(String email) {
        // Arrange
        User expectedUser = new User();
        when(userService.findByEmail(email)).thenReturn(expectedUser);

        // Act
        ResponseEntity<User> response = userRESTController.getUserByEmail(email);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedUser, response.getBody());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testGetUserById(int id) {
        // Arrange
        User expectedUser = new User();
        when(userService.findById(eq(id))).thenReturn(expectedUser);

        // Act
        ResponseEntity<User> response = userRESTController.getUserById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedUser, response.getBody());
    }

    // Test login
    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testUserLogin(String email) {
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail(email);
        expectedUser.setPassword("password123");
        when(userService.findByEmail(email)).thenReturn(expectedUser);

        // Act
        ResponseEntity<User> response = userRESTController.userLogin(expectedUser);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedUser, response.getBody());
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testUserLoginNotFound(String email) {
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail(email);
        expectedUser.setPassword("password123");
        when(userService.findByEmail(email)).thenReturn(null);

        // Act
        ResponseEntity<User> response = userRESTController.userLogin(expectedUser);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testUserLoginInvalidPassword(String email) {
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail(email);
        expectedUser.setPassword("correctPassword");  // Pass a different password here
        when(userService.findByEmail(email)).thenReturn(expectedUser);

        // Act
        ResponseEntity<User> response = userRESTController.userLogin(
                new User(expectedUser.getEmail(), "wrongPassword")  // Pass a wrong password here
        );

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testCreateUser(String email) {
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail(email);
        expectedUser.setPassword("password123");
        when(userService.save(expectedUser)).thenReturn(expectedUser);

        // Act
        ResponseEntity<User> response = userRESTController.createUser(expectedUser);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedUser, response.getBody());
    }

    //test create user 2
    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testCreateUser2(String email) {
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail(email);
        expectedUser.setPassword("password123");
        expectedUser.setRole(Roles.ADMIN);
        expectedUser.setPhoneNumber(55783456);
        expectedUser.setName("Kurt");
        when(userService.save(expectedUser)).thenReturn(expectedUser);

        // Act
        ResponseEntity<User> response = userRESTController.createUser(expectedUser);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedUser, response.getBody());
        assertEquals(expectedUser.getRole(), response.getBody().getRole());
        assertEquals(expectedUser.getEmail(), response.getBody().getEmail());
        assertEquals(expectedUser.getPhoneNumber(), response.getBody().getPhoneNumber());
        assertEquals(expectedUser.getName(), response.getBody().getName());

    }

    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testCreateUserNull(String email) {
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail(email);
        expectedUser.setPassword("password123");
        when(userService.save(expectedUser)).thenReturn(null);

        // Act
        ResponseEntity<User> response = userRESTController.createUser(expectedUser);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    // Test to get the role of a user
    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testGetUserRole(String email) {
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail(email);
        expectedUser.setRole(Roles.CUSTOMER);  // Set the expected role for the user
        when(userService.findByEmail(email)).thenReturn(expectedUser);

        // Act
        ResponseEntity<Roles> response = userRESTController.getUserRole(email);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Roles.CUSTOMER, response.getBody());
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testGetUserRole2(String email){
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail(email);
        expectedUser.setRole(Roles.ADMIN);
        when(userService.findByEmail(email)).thenReturn(expectedUser);

        // Act
        ResponseEntity<Roles> response = userRESTController.getUserRole(email);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Roles.ADMIN, response.getBody());
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testGetWrongUserRole(String email){
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail(email);
        expectedUser.setRole(Roles.ADMIN);
        when(userService.findByEmail(email)).thenReturn(expectedUser);

        // Act
        ResponseEntity<Roles> response = userRESTController.getUserRole(email);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotEquals(Roles.CUSTOMER, response.getBody());
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1", "user2", "user3", "user4", "user5"})
    public void testGetUserRoleNotFound(String email) {
        // Arrange
        when(userService.findByEmail(email)).thenReturn(null);

        // Act
        ResponseEntity<Roles> response = userRESTController.getUserRole(email);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }





}