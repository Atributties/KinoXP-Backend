package com.example.kinoxpbackend.entities;


import jakarta.persistence.*;

@Entity
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = "email")
    private User user;


    //Drop
    @OneToOne
    @JoinColumn(name = "movie", referencedColumnName = "id")
    private Movie movie;


    @OneToOne
    @JoinColumn(name = "showtime", referencedColumnName = "id")
    private Showtime showtime;


    //Drop
    @OneToOne
    @JoinColumn(name = "theater", referencedColumnName = "name")
    private Theater theater;


    //List of reserved seats numbers
    //Additional items maybe




}
