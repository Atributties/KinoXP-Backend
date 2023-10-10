package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findReservationById(int id);
}
