package com.example.kinoxpbackend.entities;

import com.example.kinoxpbackend.enums.AgeLimit;
import com.example.kinoxpbackend.enums.MovieCategories;
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


    @Test
    void createMovie() {
        Movie movie = new Movie();
        movie.setTitle("Sample Movie");
        movie.setCategory(MovieCategories.ACTION);
        movie.setAgeLimit(AgeLimit.R);
        movie.setDuration(120.0);
        movie.setDescription("A sample movie description");
        movieRepository.save(movie);
    }


    @Test
    void testGetCreatedMovie() {
        Movie movie = new Movie();
        movie.setTitle("Sample Movie");
        movie.setCategory(MovieCategories.ACTION);
        movie.setAgeLimit(AgeLimit.PG_13);
        movie.setDuration(120.0);
        movie.setDescription("A sample movie description");
        movieRepository.save(movie);
        List<Movie> lst =  movieRepository.findAll();
        assertEquals(1, lst.size());

    }

    @Test
    void testFindAllByTitleContaining() {
        // Insert test data into the database
        Movie movie1 = new Movie();
        movie1.setTitle("Movie Title 1");
        Movie movie2 = new Movie();
        movie2.setTitle("Another Movie Title");
        Movie movie3 = new Movie();
        movie3.setTitle("Movie 4");
        movieRepository.saveAll(List.of(movie1, movie2, movie3));

        String searchTerm = "1";
        List<Movie> movies = movieRepository.findAllByTitleContaining(searchTerm);

        // Assert that the correct number of movies containing "Movie" in their titles is found
        assertEquals(1, movies.size());
    }

    @Test
    void testFindAllByTitleContaining2() {
        // Insert test data into the database
        Movie movie1 = new Movie();
        movie1.setTitle("Movie Title 1");
        Movie movie2 = new Movie();
        movie2.setTitle("Another Movie Title");
        Movie movie3 = new Movie();
        movie3.setTitle("This is a film 4");
        movieRepository.saveAll(List.of(movie1, movie2, movie3));

        String searchTerm = "Movie";
        List<Movie> movies = movieRepository.findAllByTitleContaining(searchTerm);

        // Assert that the correct number of movies containing "Movie" in their titles is found
        assertEquals(2, movies.size());
    }

}