package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.entities.Seat;
import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.enums.TheaterName;


import java.util.List;

public class TheaterDTO {


    private int id;
    private TheaterName theaterName;
    private int numRows = 0; // Antal rækker
    private int numSeatsPrRow = 0; // Antal sæder pr. række
    private List<Showtime> showtime;
    private List<Seat> seats;


    public TheaterDTO(Theater theater) {
        this.theaterName = theater.getTheaterName();
        this.numRows = theater.getNumRows();
        this.numSeatsPrRow = theater.getNumSeatsPrRow();
        this.showtime = theater.getShowtimes();
        this.seats = theater.getSeats();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumSeatsPrRow() {
        return numSeatsPrRow;
    }

    public void setNumSeatsPrRow(int numSeatsPrRow) {
        this.numSeatsPrRow = numSeatsPrRow;
    }

    public List<Showtime> getShowtime() {
        return showtime;
    }

    public void setShowtime(List<Showtime> showtime) {
        this.showtime = showtime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }


}
