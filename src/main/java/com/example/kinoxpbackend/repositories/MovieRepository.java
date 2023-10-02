package com.example.kinoxpbackend.repositories;

import com.example.kinoxpbackend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {

    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    List<Movie> findAllByTitleContaining(@Param("title") String title);

    @Query("SELECT m FROM Movie m WHERE lower(m.category) = lower(:category)")
    List<Movie> findAllByCategoryIgnoreCase(@Param("category") String category);


}
