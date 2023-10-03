package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/showtime")
public class ShowtimeRESTController {

    @Autowired
    private ShowtimeService showtimeService;

    @PostMapping
    public ResponseEntity<Showtime> createShowtime(@RequestBody Showtime showtime) {
        Showtime createdShowtime = showtimeService.save(showtime);
        if (createdShowtime != null) {
            return new ResponseEntity<>(createdShowtime, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Showtime>> getShowtimesByMovie(@PathVariable int movieId) {
        List<Showtime> showtimes = showtimeService.findByMovieId(movieId);
        return new ResponseEntity<>(showtimes, HttpStatus.OK);
    }

}

