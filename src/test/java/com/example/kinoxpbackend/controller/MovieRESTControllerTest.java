package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.service.MovieService;
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MovieRESTControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieRESTController movieRESTController;

    private Movie movie;

    @BeforeAll
    public void beforeAll() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void beforeEach() {
        movie = new Movie();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testGetMovieById(String id){
        // Arrange
        List<Movie> expectedMovies = Collections.singletonList(new Movie());
        when(movieService.findById(id)).thenReturn(Optional.of(expectedMovies.get(0)));

        // Act
        ResponseEntity<Movie> response = movieRESTController.getMovieById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Adjust the assertion to check the content of the body
        assertEquals(expectedMovies.get(0), response.getBody());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testGetMovieByIdNotFound(String id){
        // Arrange
        when(movieService.findById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Movie> response = movieRESTController.getMovieById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testDeleteMovieById(String id){
        // Arrange
        List<Movie> expectedMovies = Collections.singletonList(new Movie());
        when(movieService.findById(id)).thenReturn(Optional.of(expectedMovies.get(0)));

        // Act
        ResponseEntity<String> response = movieRESTController.deleteMovie(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testDeleteMovieByIdNotFound(String id){
        // Arrange
        when(movieService.findById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<String> response = movieRESTController.deleteMovie(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testPutMovieById(String id){
        // Arrange
        List<Movie> expectedMovies = Collections.singletonList(new Movie());
        when(movieService.findById(id)).thenReturn(Optional.of(expectedMovies.get(0)));

        // Act
        ResponseEntity<Movie> response = movieRESTController.putMovie(id, expectedMovies.get(0));

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testPutMovieByIdNotFound(String id){
        // Arrange
        List<Movie> expectedMovies = Collections.singletonList(new Movie());
        when(movieService.findById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Movie> response = movieRESTController.putMovie(id, expectedMovies.get(0));

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testGetMoviesByTitle(String title){
        // Arrange
        List<Movie> expectedMovies = Collections.singletonList(new Movie());
        when(movieService.findAllByTitleContaining(title)).thenReturn(expectedMovies);

        // Act
        ResponseEntity<List<Movie>> response = movieRESTController.getMoviesByTitle(title);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedMovies, response.getBody());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testGetMoviesByCategory(String category){
        // Arrange
        List<Movie> expectedMovies = Collections.singletonList(new Movie());
        when(movieService.findAllByCategory(category)).thenReturn(expectedMovies);

        // Act
        ResponseEntity<List<Movie>> response = movieRESTController.getMoviesByCategory(category);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedMovies, response.getBody());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testGetMoviesByAgeLimit(String ageLimit){
        // Arrange
        List<Movie> expectedMovies = Collections.singletonList(new Movie());
        when(movieService.findAllByAgeLimitIgnoreCase(ageLimit)).thenReturn(expectedMovies);

        // Act
        ResponseEntity<List<Movie>> response = movieRESTController.getMoviesByAgeLimit(ageLimit);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedMovies, response.getBody());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void testPostMovie(String id){
        // Arrange
        List<Movie> expectedMovies = Collections.singletonList(new Movie());
        when(movieService.save(expectedMovies.get(0))).thenReturn(expectedMovies.get(0));

        // Act
        ResponseEntity<Movie> response = movieRESTController.postMovie(expectedMovies.get(0));

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedMovies.get(0), response.getBody());
    }


}