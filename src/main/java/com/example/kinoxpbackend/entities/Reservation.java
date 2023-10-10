package com.example.kinoxpbackend.entities;


import jakarta.persistence.*;

@Entity
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "showtime", referencedColumnName = "id")
    private Showtime showtime;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    //List of reserved seats numbers
    //Additional items maybe




}
