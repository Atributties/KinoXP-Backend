package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

    List<Showtime> findByMovieId(int movieId);


}

