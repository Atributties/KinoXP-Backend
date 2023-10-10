package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.entities.Reservation;
import com.example.kinoxpbackend.entities.SeatReservation;

public class SeatReservationDTO {

    private int id;
    private Reservation reservation;
    private String oneRow;
    private int seatNumber;


    public SeatReservationDTO(SeatReservation seatReservation) {
        this.id = seatReservation.getId();
        this.reservation = seatReservation.getReservation();
        this.oneRow = seatReservation.getOneRow();
        this.seatNumber = seatReservation.getSeatNumber();
    }

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
