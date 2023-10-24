package com.example.kinoxpbackend.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
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

}
