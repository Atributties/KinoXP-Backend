package com.example.kinoxpbackend.controller;


import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MovieRESTController {


    @Autowired
    MovieRepository movieRepository;

    //All these method get the data from our database.
    @GetMapping("/movie")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }







}
