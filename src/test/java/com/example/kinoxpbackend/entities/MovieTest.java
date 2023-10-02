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

    @Test
    void testFindAllByCategory() {
        // Insert test data into the database
        Movie movie1 = new Movie();
        movie1.setTitle("Movie Title 1");
        movie1.setCategory(MovieCategories.ACTION);
        Movie movie2 = new Movie();
        movie2.setTitle("Another Movie Title");
        movie2.setCategory(MovieCategories.ACTION);
        Movie movie3 = new Movie();
        movie3.setTitle("This is a film 4");
        movie3.setCategory(MovieCategories.COMEDY);
        movieRepository.saveAll(List.of(movie1, movie2, movie3));

        // Ensure that the category comparison is case-insensitive
        String searchTerm = "action";
        List<Movie> movies = movieRepository.findAllByCategoryIgnoreCase(searchTerm);

        // Assert that the correct number of movies with the category "ACTION" is found
        assertEquals(2, movies.size());
    }

    @Test
    void testFindAllByCategory2() {
        // Insert test data into the database
        Movie movie1 = new Movie();
        movie1.setTitle("Movie Title 1");
        movie1.setCategory(MovieCategories.ACTION);
        Movie movie2 = new Movie();
        movie2.setTitle("Another Movie Title");
        movie2.setCategory(MovieCategories.ACTION);
        Movie movie3 = new Movie();
        movie3.setTitle("This is a film 4");
        movie3.setCategory(MovieCategories.COMEDY);
        movieRepository.saveAll(List.of(movie1, movie2, movie3));

        // Ensure that the category comparison is case-insensitive
        String searchTerm = "comedy";
        List<Movie> movies = movieRepository.findAllByCategoryIgnoreCase(searchTerm);

        // Assert that the correct number of movies with the category "COMEDY" is found
        assertEquals(1, movies.size());
    }


}