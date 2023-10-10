package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.entities.Reservation;
import com.example.kinoxpbackend.repositories.ReservationRepository;
import com.example.kinoxpbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
        private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservationsById(int id){
        return reservationRepository.findReservationById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
