package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.entities.Seat;
import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.enums.SeatStatus;
import com.example.kinoxpbackend.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    private SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }


    public void initializeSeatsForTheater(Theater theater) {
        for (int row = 1; row <= theater.getNumRows(); row++) {
            for (int seatNumber = 1; seatNumber <= theater.getNumSeatsPrRow(); seatNumber++) {
                Seat seat = new Seat();
                seat.setOneRow(String.valueOf((char) ('A' + row - 1))); // Konverter række til bogstav ('A' for række 1, 'B' for række 2 osv.)
                seat.setSeatNumber(seatNumber);
                seat.setStatus(SeatStatus.AVAILABLE); // Sæt startstatus som ledig
                seat.setTheater(theater); // Tilknyt sædet til teatret
                seatRepository.save(seat); // Gem sædet
            }
        }
    }



}
