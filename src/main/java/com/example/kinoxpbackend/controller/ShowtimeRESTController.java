package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.ShowtimeDTO;
import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ShowtimeRESTController {

    @Autowired
    private ShowtimeService showtimeService;


    @GetMapping("/showtimes")
    public ResponseEntity<List<ShowtimeDTO>> getAllShowtimes() {
        try {
            List<Showtime> showtimes = showtimeService.getAllShowtimes();
            // Konverter Showtime-objekter til ShowtimeDTO-objekter
            List<ShowtimeDTO> showtimeDTOs = showtimes.stream()
                    .map(ShowtimeDTO::new) // Bruger din ShowtimeDTO-konstruktor
                    .collect(Collectors.toList());

            return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/showtime/{id}")
    public ResponseEntity<ShowtimeDTO> getShowtimeById(@PathVariable int id) {
        try {
            Showtime showtime = showtimeService.getShowtimeById(id);
            if (showtime != null) {
                ShowtimeDTO showtimeDTO = new ShowtimeDTO(showtime);
                System.out.println("Showtime: " + showtimeDTO.getSeatDTOS());
                return new ResponseEntity<>(showtimeDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/showtime/movie/{movieId}")
    public ResponseEntity<List<ShowtimeDTO>> getShowtimesByMovie(@PathVariable int movieId) {
        try {
            List<Showtime> showtimes = showtimeService.findByMovieId(movieId);
            // Konverter Showtime-objekter til ShowtimeDTO-objekter
            List<ShowtimeDTO> showtimeDTOs = showtimes.stream()
                    .map(ShowtimeDTO::new) // Bruger din ShowtimeDTO-konstruktor
                    .collect(Collectors.toList());

            return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/showtime")
    public ResponseEntity<Showtime> createShowtime(@RequestBody Showtime showtime) {
        Theater theater = showtimeService.getTheaterById(showtime.getTheater().getId());
        try {
            Showtime createdShowtime = showtimeService.save(showtime);
            if (createdShowtime != null) {
                showtimeService.initializeSeatsForShowtime(theater, showtime);
                return new ResponseEntity<>(createdShowtime, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

