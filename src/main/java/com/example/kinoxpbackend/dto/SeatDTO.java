package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.entities.Seat;
import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.enums.SeatStatus;


public class SeatDTO {

    private int id;
    private String oneRow;
    private int seatNumber;
    private SeatStatus status;
    private Theater theater;


    public SeatDTO(Seat seat) {
        this.id = seat.getId();
        this.oneRow = seat.getOneRow();
        this.seatNumber = seat.getSeatNumber();
        this.status = seat.getStatus();
        this.theater = seat.getTheater();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
