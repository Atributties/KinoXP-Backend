package com.example.kinoxpbackend.repositories;


import com.example.kinoxpbackend.entities.Theater;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {



}
