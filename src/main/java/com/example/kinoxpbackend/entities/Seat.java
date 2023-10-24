package com.example.kinoxpbackend.entities;


import com.example.kinoxpbackend.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String oneRow;
    private int seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @ManyToOne
    @JoinColumn(name = "theater", referencedColumnName = "id")
    private Theater theater;     // Reference til det tilknyttede teater

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;


    public Seat() {
    }

    public Seat(String oneRow, int seatNumber, SeatStatus status, Theater theater, Showtime showtime) {
        this.oneRow = oneRow;
        this.seatNumber = seatNumber;
        this.status = status;
        this.theater = theater;
        this.showtime = showtime;
    }


}