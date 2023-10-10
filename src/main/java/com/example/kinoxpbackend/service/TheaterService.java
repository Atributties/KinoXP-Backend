package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    private TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public void save(Theater theater) {
        theaterRepository.save(theater);
    }
}
