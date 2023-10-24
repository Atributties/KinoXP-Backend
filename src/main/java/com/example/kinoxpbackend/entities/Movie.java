package com.example.kinoxpbackend.entities;


import com.example.kinoxpbackend.enums.AgeLimit;
import com.example.kinoxpbackend.enums.MovieCategories;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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


}
