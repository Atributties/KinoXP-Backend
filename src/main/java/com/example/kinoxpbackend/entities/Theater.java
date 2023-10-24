package com.example.kinoxpbackend.entities;


import com.example.kinoxpbackend.enums.TheaterName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TheaterName theaterName;

    private int numRows = 0; // Antal rækker
    private int numSeatsPrRow = 0; // Antal sæder pr. række

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Showtime> showtimes;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;


    public Theater() {
    }
    public Theater(TheaterName theaterName) {
        this.theaterName = TheaterName.valueOf(theaterName.name()); // Navnet fra enum
    }


}
