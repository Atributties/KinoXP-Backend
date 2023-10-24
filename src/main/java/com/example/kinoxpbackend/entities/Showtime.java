package com.example.kinoxpbackend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private LocalTime time;



    @ManyToOne
    @JoinColumn(name = "movie", referencedColumnName = "id")
    private Movie movie;


    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "theater", referencedColumnName = "id")
    private Theater theater;

    @OneToMany(mappedBy = "showtime", fetch = FetchType.LAZY)
    private List<Seat> seats;


    public Showtime() {
    }

    public Showtime(LocalDate date, LocalTime time, Movie movie, Theater theater) {
        this.date = date;
        this.time = time;
        this.movie = movie;
        this.theater = theater;
    }

    public Showtime(LocalDate date, LocalTime time, Movie movie, List<Reservation> reservation, Theater theater, List<Seat> seats) {
        this.date = date;
        this.time = time;
        this.movie = movie;
        this.reservations = reservation;
        this.theater = theater;
        this.seats = seats;
    }

    public Showtime(int id) {
        this.id = id;

    }

}
