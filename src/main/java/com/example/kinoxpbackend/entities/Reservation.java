package com.example.kinoxpbackend.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "showtime", referencedColumnName = "id")
    private Showtime showtime;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<SeatReservation> seatReservations;


    public Reservation() {
    }

    public Reservation(User user, Showtime showtime, List<SeatReservation> seatReservations) {
        this.user = user;
        this.showtime = showtime;
        this.seatReservations = seatReservations;

    }


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

    public List<SeatReservation> getSeatReservations() {
        return seatReservations;
    }

    public void setSeatReservations(List<SeatReservation> seatReservations) {
        this.seatReservations = seatReservations;
    }
}
