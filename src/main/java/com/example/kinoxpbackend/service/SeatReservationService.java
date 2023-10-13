package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.entities.SeatReservation;
import com.example.kinoxpbackend.repositories.SeatReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatReservationService {

    private SeatReservationRepository seatReservationRepository;

    @Autowired
    public SeatReservationService(SeatReservationRepository seatReservationRepository) {
        this.seatReservationRepository = seatReservationRepository;
    }

    public void saveSeatReservation(SeatReservation seatReservation1) {
        seatReservationRepository.save(seatReservation1);
    }
}
