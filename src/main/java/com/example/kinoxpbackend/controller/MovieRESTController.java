package com.example.kinoxpbackend.controller;


import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.repositories.MovieRepository;
import com.example.kinoxpbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class MovieRESTController {

    @Autowired
    MovieService movieService;

    //All these method get the data from our database.
    @GetMapping("/movie")
    public List<Movie> getMovies() {
        return movieService.findAll();
    }

    @GetMapping("/movie/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.findAllByTitleContaining(title);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


    @PostMapping("/movie")
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.save(movie);
        if(createdMovie == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
        }
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> putMovie(@PathVariable String id, @RequestBody Movie movie) {
        Optional<Movie> orgMovie = movieService.findById(id);
        if(orgMovie.isPresent()) {
            movie.setId(Integer.parseInt(id));
            movieService.save(movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/movie/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable String id){
        Optional<Movie> orgMovie = movieService.findById(id);
        if(orgMovie.isPresent()) {
            movieService.deleteById(id);
            return ResponseEntity.ok("Movie deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
    }















}
