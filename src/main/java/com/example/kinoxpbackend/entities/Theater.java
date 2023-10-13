package com.example.kinoxpbackend.entities;


import com.example.kinoxpbackend.enums.TheaterName;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TheaterName theaterName;

    private int numRows = 0; // Antal rækker
    private int numSeatsPrRow = 0; // Antal sæder pr. række

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Showtime> showtimes;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Theater() {
    }
    public Theater(TheaterName theaterName) {
        this.theaterName = TheaterName.valueOf(theaterName.name()); // Navnet fra enum
    }

    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public TheaterName getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(TheaterName theaterName) {
        this.theaterName = theaterName;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumSeatsPrRow() {
        return numSeatsPrRow;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public void setNumSeatsPrRow(int numSeatsPrRow) {
        this.numSeatsPrRow = numSeatsPrRow;
    }

}
