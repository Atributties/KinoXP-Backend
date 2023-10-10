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
    private TheaterName name;
    private static final int NUM_ROWS = 10; // Antal rækker
    private static final int NUM_SEATS_PER_ROW = 20; // Antal sæder pr. række


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
        this.name = TheaterName.valueOf(theaterName.name()); // Navnet fra enum
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

    public TheaterName getName() {
        return name;
    }

    public void setName(TheaterName name) {
        this.name = name;
    }
}
