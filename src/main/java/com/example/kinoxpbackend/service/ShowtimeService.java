package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.entities.Showtime;
import com.example.kinoxpbackend.repositories.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    public Showtime save(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }
}

