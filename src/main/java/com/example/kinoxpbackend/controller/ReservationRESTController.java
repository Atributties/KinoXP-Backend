package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.entities.Reservation;
import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class ReservationRESTController {

    @Autowired
    private ReservationService reservationService;
    @GetMapping("/reservation/{id}")
    public ResponseEntity<List<Reservation>> getReservationsById(@PathVariable int id) {
        List<Reservation> reservations = reservationService.getReservationsById(id);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

}
