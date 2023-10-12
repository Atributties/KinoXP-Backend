package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.entities.Seat;
import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.enums.SeatStatus;
import com.example.kinoxpbackend.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {
    private SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }


    public List<Seat> createSeatsForShowtime(Theater theater, Showtime showtime) {
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= theater.getNumRows(); row++) {
            for (int seatNumber = 1; seatNumber <= theater.getNumSeatsPrRow(); seatNumber++) {
                Seat seat = new Seat();
                seat.setOneRow(String.valueOf((char) ('A' + row - 1)));
                seat.setSeatNumber(seatNumber);
                seat.setStatus(SeatStatus.AVAILABLE);
                seat.setTheater(theater);
                seat.setShowtime(showtime);
                seats.add(seat);
            }
        }
        return seatRepository.saveAll(seats);
    }
}
