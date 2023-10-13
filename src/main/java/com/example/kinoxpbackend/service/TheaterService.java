package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.enums.TheaterName;
import com.example.kinoxpbackend.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Theater findByTheaterName(String theaterName) {
        return theaterRepository.findByTheaterName(TheaterName.valueOf(theaterName));
    }



    public List<Theater> getAllTheater() {
        return theaterRepository.findAll();
    }

    public Theater findTheaterById(int id) {
        return theaterRepository.findTheaterById(id);
    }
}
