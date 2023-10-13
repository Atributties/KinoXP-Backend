package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.ReservationDTO;
import com.example.kinoxpbackend.entities.*;
import com.example.kinoxpbackend.enums.SeatStatus;
import com.example.kinoxpbackend.enums.TheaterName;
import com.example.kinoxpbackend.service.ReservationService;
import com.example.kinoxpbackend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ReservationRESTController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private SeatService seatService;



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


    @PostMapping("/reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservationRequest) {
        // Deserialize the JSON request into a Reservation object
        Reservation reservation = new Reservation(
                reservationRequest.getUser(),
                reservationRequest.getShowtime(),
                new ArrayList<>()
        );

        List<SeatReservation> newSeatReservations = new ArrayList<>();  // Create a separate list to hold new SeatReservations

        // Process the SeatReservation objects in the request
        for (SeatReservation seatReservationRequest : reservationRequest.getSeatReservations()) {
            // Create new SeatReservation instances and add them to the separate list
            SeatReservation seatReservation = new SeatReservation(
                    reservation,
                    seatReservationRequest.getOneRow(),
                    seatReservationRequest.getSeatNumber()
            );
            newSeatReservations.add(seatReservation);

            Seat seat = seatService.getSeatById(seatReservationRequest.getId());
            seat.setStatus(SeatStatus.RESERVED);
            seatService.save(seat);
        }

        // Add all the new SeatReservations to the Reservation's list of seatReservations after the iteration is complete
        reservation.getSeatReservations().addAll(newSeatReservations);

        // Save the Reservation, which will cascade the save operation to associated SeatReservation instances
        Reservation createdReservation = reservationService.save(reservation);

        if (createdReservation != null) {
            return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
