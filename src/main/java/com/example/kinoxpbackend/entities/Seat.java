package com.example.kinoxpbackend.entities;


import com.example.kinoxpbackend.enums.SeatStatus;
import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String oneRow;
    private int seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @ManyToOne
    @JoinColumn(name = "theater", referencedColumnName = "id")
    private Theater theater;     // Reference til det tilknyttede teater

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;


    public Seat() {
    }

    public Seat(String oneRow, int seatNumber, SeatStatus status, Theater theater, Showtime showtime) {
        this.oneRow = oneRow;
        this.seatNumber = seatNumber;
        this.status = status;
        this.theater = theater;
        this.showtime = showtime;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
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