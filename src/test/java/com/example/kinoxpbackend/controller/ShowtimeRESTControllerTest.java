package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.service.ShowtimeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShowtimeRESTControllerTest {

    @Mock
    private ShowtimeService showtimeService;

    @InjectMocks
    private ShowtimeRESTController showtimeRESTController;

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
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testGetShowtimeById(int id) {
        // Arrange
        List<Showtime> expectedShowtimes = Collections.singletonList(new Showtime());
        when(showtimeService.findByMovieId(id)).thenReturn(expectedShowtimes);

        // Act
        ResponseEntity<List<Showtime>> response = showtimeRESTController.getShowtimesByMovie(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() == expectedShowtimes);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testCreateShowtime() {
        // Arrange
        Showtime showtime = new Showtime();
        showtime.setMovie(movie);
        when(showtimeService.save(showtime)).thenReturn(showtime);

        // Act
        ResponseEntity<Showtime> response = showtimeRESTController.createShowtime(showtime);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getBody() == showtime);
    }
}
