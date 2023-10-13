package com.example.kinoxpbackend.controller;


import com.example.kinoxpbackend.dto.ShowtimeDTO;
import com.example.kinoxpbackend.dto.TheaterDTO;
import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class TheaterRESTController {

    @Autowired
    private TheaterService theaterService;


    //All these method get the data from our database.

    @GetMapping("/theaters")
    public ResponseEntity<List<TheaterDTO>> getAllTheater() {
        try {
            List<Theater> theaters = theaterService.getAllTheater();
            // Konverter Showtime-objekter til ShowtimeDTO-objekter
            List<TheaterDTO> theaterDTOS = theaters.stream()
                    .map(TheaterDTO::new) // Bruger din ShowtimeDTO-konstruktor
                    .toList();

            return new ResponseEntity<>(theaterDTOS, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
