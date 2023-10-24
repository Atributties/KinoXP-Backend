package com.example.kinoxpbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SeatReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "reservation", referencedColumnName = "id")
    @JsonBackReference
    private Reservation reservation;

    private String oneRow;
    private int seatNumber;

    public SeatReservation() {
    }

    public SeatReservation(Reservation reservation, String oneRow, int seatNumber) {
        this.reservation = reservation;
        this.oneRow = oneRow;
        this.seatNumber = seatNumber;
    }

}
