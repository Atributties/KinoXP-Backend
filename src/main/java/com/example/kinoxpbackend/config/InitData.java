package com.example.kinoxpbackend.config;


import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {


    @Autowired
    MovieService movieService;

    @Override
    public void run(String... args) throws Exception {

        // Create and save movie entities using the MovieService
        Movie movie1 = new Movie();
        movie1.setTitle("Movie Title 1");
        movie1.setCategory("Action");
        movie1.setAgeLimit(18);
        movie1.setDuration(120.0);
        movie1.setDescription("A sample movie description");

        Movie movie2 = new Movie();
        movie2.setTitle("Another Movie Title");
        movie2.setCategory("Comedy");
        movie2.setAgeLimit(12);
        movie2.setDuration(110.5);
        movie2.setDescription("Another movie description");

        // Save movies to the database
        movieService.save(movie1);
        movieService.save(movie2);





    }



}