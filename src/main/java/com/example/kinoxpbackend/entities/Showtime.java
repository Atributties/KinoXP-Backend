package com.example.kinoxpbackend.entities;


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
    //Movie object
    //Theater object


    @ManyToOne
    @JoinColumn(name = "movie", referencedColumnName = "id")
    private Movie movie;


    @OneToOne(mappedBy = "showtime")
    private Reservation reservation;

    @OneToOne
    @JoinColumn(name = "theater", referencedColumnName = "name")
    private Theater theater;

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
