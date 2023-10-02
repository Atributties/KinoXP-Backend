package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public void MyEntityServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllByTitleContaining(String title) {
        return movieRepository.findAllByTitleContaining(title);
    }


    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}