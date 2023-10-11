package com.example.kinoxpbackend.config;


import com.example.kinoxpbackend.entities.*;
import com.example.kinoxpbackend.enums.AgeLimit;
import com.example.kinoxpbackend.enums.MovieCategories;
import com.example.kinoxpbackend.enums.Roles;
import com.example.kinoxpbackend.enums.TheaterName;
import com.example.kinoxpbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {


    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    ShowtimeService showtimeService;
    @Autowired
    TheaterService theaterService;
    @Autowired
    SeatService seatService;
    @Autowired
    SeatReservationService seatReservationService;

    @Override
    public void run(String... args) throws Exception {

        Theater largeTheater = new Theater(TheaterName.THEATER_LARGE);
        largeTheater.setNumRows(15);
        largeTheater.setNumSeatsPrRow(20);

        theaterService.save(largeTheater);
        seatService.initializeSeatsForTheater(largeTheater);

        Theater smallTheater = new Theater(TheaterName.THEATER_SMALL);
        smallTheater.setNumRows(8);
        smallTheater.setNumSeatsPrRow(15);

        theaterService.save(smallTheater);
        seatService.initializeSeatsForTheater(smallTheater);

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
        movie3.setTitle("Movie title 3");
        movie3.setImageUrl("https://img-cdn.sfanytime.com/COVERM/99a66254-3e74-4698-b9fb-9f81010f5574_COVERM_01.jpg?w=375&ar=0.692&fit=crop&fm=pjpg&s=9b39d41ba54811a9f2ba609ee8d780dd");
        movie3.setCategory(MovieCategories.DOCUMENTARY);
        movie3.setAgeLimit(AgeLimit.PG_13);
        movie3.setDuration(190.0);
        movie3.setDescription("Another movie description");

        // Save movies to the database
        movieService.save(movie1);
        movieService.save(movie2);
        movieService.save(movie3);


        // Create and save user entities using the UserService
        User user1 = new User("John Doe", Roles.CUSTOMER, "password123", "johndoe@example.com", "123456");
        userService.save(user1);

        User user2 = new User("Jane Smith", Roles.CUSTOMER, "securepassword", "janesmith@example.com", "987654");
        userService.save(user2);

        User user3 = new User("Admin User", Roles.ADMIN, "adminpassword", "admin@example.com", "23232323");
        userService.save(user3);

        //create a showtime for movie 1
        Showtime showtime1 = new Showtime(LocalDate.of(2021, 5, 20), LocalTime.of(20, 0), movie1, null);
        showtimeService.save(showtime1);
        Showtime showtime2 = new Showtime(LocalDate.of(2023, 7, 21), LocalTime.of(20, 0), movie1, null);
        showtimeService.save(showtime2);
        Showtime showtime3 = new Showtime(LocalDate.of(2023, 8, 15), LocalTime.of(20, 0), movie1, null);
        showtimeService.save(showtime3);
        Showtime showtime4 = new Showtime(LocalDate.of(2024, 1, 20), LocalTime.of(20, 0), movie2, null);
        showtimeService.save(showtime4);
        Showtime showtime5 = new Showtime(LocalDate.of(2024, 2, 10), LocalTime.of(20, 0), movie3, null);
        showtimeService.save(showtime5);


    }

}
