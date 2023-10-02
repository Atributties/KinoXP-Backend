package com.example.kinoxpbackend.entities;

import com.example.kinoxpbackend.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
class MovieTest {


    @Autowired
    MovieRepository movieRepository;


    @BeforeEach
    void setupTestData(){
        // Arrange: Create a new movie entity with sample attributes.
        Movie movie = new Movie();
        movie.setTitle("Sample Movie");
        movie.setCategory("Action");
        movie.setAgeLimit(18);
        movie.setDuration(120.0);
        movie.setDescription("A sample movie description");

        // Act: Save the movie to the database.
        movieRepository.save(movie);
    }



    @Test
    void testGetCreatedMovie() {
        List<Movie> lst =  movieRepository.findAll();
        assertEquals(1, lst.size());

    }














}