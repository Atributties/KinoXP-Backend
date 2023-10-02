package com.example.kinoxpbackend.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String category;
    private int ageLimit;
    private Double duration;
    private String description;



    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Showtime> showtimes = new HashSet<>();


    @OneToOne(mappedBy = "movie")
    private Reservation reservation;




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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
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
