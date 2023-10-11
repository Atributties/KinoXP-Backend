package com.example.kinoxpbackend.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Showtime {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private LocalTime time;



    @ManyToOne
    @JoinColumn(name = "movie", referencedColumnName = "id")
    private Movie movie;


    @OneToOne(mappedBy = "showtime")
    @JsonManagedReference(value="showtimeReference")
    private Reservation reservation;

    @OneToOne
    @JoinColumn(name = "theater", referencedColumnName = "id")
    private Theater theater;


    public Showtime() {
    }

    public Showtime(LocalDate date, LocalTime time, Movie movie, Theater theater) {
        this.date = date;
        this.time = time;
        this.movie = movie;
        this.theater = theater;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
