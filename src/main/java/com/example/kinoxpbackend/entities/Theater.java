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



    @OneToOne(mappedBy = "theater")
    private Showtime showtime;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;


    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Theater() {
    }
    public Theater(TheaterName theaterName) {
        this.theaterName = TheaterName.valueOf(theaterName.name()); // Navnet fra enum
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
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
