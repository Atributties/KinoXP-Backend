package com.example.kinoxpbackend.entities;


import com.example.kinoxpbackend.enums.AgeLimit;
import com.example.kinoxpbackend.enums.MovieCategories;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Enumerated(EnumType.STRING) // Use EnumType.STRING to store enum values as strings in the database
    private MovieCategories category;
    @Enumerated(EnumType.STRING)
    private AgeLimit ageLimit;
    private Double duration;
    private String description;
    private String imageUrl;



    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<Showtime> showtimes = new HashSet<>();


    @OneToOne(mappedBy = "movie")
    private Reservation reservation;

    public Movie() {
    }
    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Movie(String title, String imageUrl, MovieCategories category, AgeLimit ageLimit, Double duration, String description) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.category = category;
        this.ageLimit = ageLimit;
        this.duration = duration;
        this.description = description;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Set<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(Set<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieCategories getCategory() {
        return category;
    }

    public void setCategory(MovieCategories category) {
        this.category = category;
    }

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
