package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.ReservationDTO;
import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.entities.Reservation;
import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ReservationRESTController {

    @Autowired
    private ReservationService reservationService;



    @GetMapping("/reservation/{id}")
    public ResponseEntity<ReservationDTO> getReservationsById(@PathVariable int id) {
        Optional<Reservation> reservation = reservationService.findById(id);
        if (reservation.isPresent()) {
            ReservationDTO reservationDTO = new ReservationDTO(reservation.get());
            return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.save(reservation);
        if (createdReservation != null) {
            return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
