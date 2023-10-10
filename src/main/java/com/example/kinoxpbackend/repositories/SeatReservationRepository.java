package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.entities.SeatReservation;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, Integer> {



}
