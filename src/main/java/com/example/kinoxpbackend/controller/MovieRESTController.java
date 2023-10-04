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

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
        Optional<Movie> movie = movieService.findById(id);
        if(movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/movie/title/{title}")
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

    @GetMapping("/movie/category/{category}")
    public ResponseEntity<List<Movie>> getMoviesByCategory(@PathVariable String category) {
        List<Movie> movies = movieService.findAllByCategory(category);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/movie/ageLimit/{ageLimit}")
    public ResponseEntity<List<Movie>> getMoviesByAgeLimit(@PathVariable String ageLimit) {
        List<Movie> movies = movieService.findAllByAgeLimitIgnoreCase(ageLimit);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/movie/titles")
    public ResponseEntity<List<Movie>> getMovieTitles() {
        List<Movie> movieTitles = movieService.findAll().stream()
                .map(movie -> new Movie(movie.getId(), movie.getTitle()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(movieTitles, HttpStatus.OK);
    }

}
