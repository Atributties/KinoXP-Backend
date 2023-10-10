package com.example.kinoxpbackend.repositories;


import com.example.kinoxpbackend.entities.Theater;
import com.example.kinoxpbackend.enums.TheaterName;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {


    Theater findByTheaterName(TheaterName theaterName);
}
