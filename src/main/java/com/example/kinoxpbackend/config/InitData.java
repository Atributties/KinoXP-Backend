package com.example.kinoxpbackend.config;


import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.enums.AgeLimit;
import com.example.kinoxpbackend.enums.MovieCategories;
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
        movie1.setImageUrl("https://www.nfbio.dk/sites/nfbio.dk/files/styles/movie_poster/public/media-images/2023-08/ODYyM2IxOTItMzY4Mi00MWY5LWEyMWQtZjgwYmZlNWY2YWZh.jpg?itok=pzYelf19");
        movie1.setCategory(MovieCategories.ACTION);
        movie1.setAgeLimit(AgeLimit.R);
        movie1.setDuration(120.0);
        movie1.setDescription("A sample movie description");

        Movie movie2 = new Movie();
        movie2.setTitle("Movie title 2");
        movie2.setImageUrl("https://img-cdn.sfanytime.com/COVERM/99a66254-3e74-4698-b9fb-9f81010f5574_COVERM_01.jpg?w=375&ar=0.692&fit=crop&fm=pjpg&s=9b39d41ba54811a9f2ba609ee8d780dd");
        movie2.setCategory(MovieCategories.COMEDY);
        movie2.setAgeLimit(AgeLimit.PG_13);
        movie2.setDuration(110.0);
        movie2.setDescription("Another movie description");

        Movie movie3 = new Movie();
        movie2.setTitle("Movie title 3");
        movie2.setImageUrl("https://img-cdn.sfanytime.com/COVERM/99a66254-3e74-4698-b9fb-9f81010f5574_COVERM_01.jpg?w=375&ar=0.692&fit=crop&fm=pjpg&s=9b39d41ba54811a9f2ba609ee8d780dd");
        movie2.setCategory(MovieCategories.DOCUMENTARY);
        movie2.setAgeLimit(AgeLimit.PG_13);
        movie2.setDuration(190.0);
        movie2.setDescription("Another movie description");

        // Save movies to the database
        movieService.save(movie1);
        movieService.save(movie2);





    }



}
