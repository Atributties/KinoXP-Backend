package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.entities.Seat;
import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.exceptions.ShowtimesNotFoundException;
import com.example.kinoxpbackend.repositories.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {
    private ShowtimeRepository showtimeRepository;
    private SeatService seatService;
    private TheaterService theaterService;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository, SeatService seatService, TheaterService theaterService) {
        this.showtimeRepository = showtimeRepository;
        this.seatService = seatService;
        this.theaterService = theaterService;
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
        List<Showtime> showtimes = showtimeRepository.findByMovieId(movieId);
        if (showtimes == null || showtimes.isEmpty()) {
            throw new ShowtimesNotFoundException("No showtimes found for movie with ID: " + movieId);
        }
        return showtimes;
    }
    public List<Showtime> getAllShowtimes() {
        List<Showtime> showtimes = showtimeRepository.findAll();
        if (showtimes == null || showtimes.isEmpty()) {
            throw new ShowtimesNotFoundException("No showtimes found.");
        }
        return showtimes;
    }
    public Showtime getShowtimeById(int id) {
        return showtimeRepository.getReferenceById(id);
    }


    public Theater getTheaterById(int id) {
        return theaterService.findTheaterById(id);
    }
}


