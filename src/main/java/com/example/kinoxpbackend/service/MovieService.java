package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.exceptions.MovieNotFoundException;
import com.example.kinoxpbackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public void MyEntityServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllByTitleContaining(String title) {
        List<Movie> movies = movieRepository.findAllByTitleContaining(title);
        if (movies.isEmpty()) {
            throw new MovieNotFoundException("No movies found with the title containing: " + title);
        }
        return movies;
    }


    public List<Movie> findAll() {
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            throw new MovieNotFoundException("No movies found.");
        }
        return movies;
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> findById(String id) {
        return movieRepository.findById(id);
    }

    public void deleteById(String id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> findAllByCategory(String category) {
        List<Movie> movies = movieRepository.findAllByCategoryIgnoreCase(category);
        if (movies.isEmpty()) {
            throw new MovieNotFoundException("No movies found in the category: " + category);
        }
        return movies;
    }

    public List<Movie> findAllByAgeLimitIgnoreCase(String ageLimit) {
        List<Movie> movies = movieRepository.findAllByAgeLimitIgnoreCase(ageLimit);
        if (movies.isEmpty()) {
            throw new MovieNotFoundException("No movies found for the age limit: " + ageLimit);
        }
        return movies;
    }
}
