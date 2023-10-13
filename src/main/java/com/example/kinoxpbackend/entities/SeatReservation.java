package com.example.kinoxpbackend.entities;

import com.example.kinoxpbackend.entities.Reservation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Entity
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



    // Andre egenskaber og metoder

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getOneRow() {
        return oneRow;
    }

    public void setOneRow(String oneRow) {
        this.oneRow = oneRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

}
