package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.dto.ShowtimeDTO;
import com.example.kinoxpbackend.entities.Seat;
import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.enums.SeatStatus;
import com.example.kinoxpbackend.repositories.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService {
    private ShowtimeRepository showtimeRepository;
    private SeatService seatService;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository, SeatService seatService) {
        this.showtimeRepository = showtimeRepository;
        this.seatService = seatService;
    }

    public void initializeSeatsForShowtime(Theater theater, Showtime showtime) {
        List<Seat> seats = seatService.createSeatsForShowtime(theater, showtime);
        showtime.setSeats(seats);
        showtimeRepository.save(showtime);
    }


    public Showtime save(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public List<Showtime> findByMovieId(int movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime getShowtimeById(int id) {
        return showtimeRepository.getReferenceById(id);
    }


}


