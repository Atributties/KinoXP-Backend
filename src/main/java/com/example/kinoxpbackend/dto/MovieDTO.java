package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.entities.Movie;
import com.example.kinoxpbackend.enums.AgeLimit;
import com.example.kinoxpbackend.enums.MovieCategories;


public class MovieDTO {

    private int id;
    private String title;
    private MovieCategories category;
    private AgeLimit ageLimit;
    private Double duration;
    private String description;
    private String imageUrl;


    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.category = movie.getCategory();
        this.ageLimit = movie.getAgeLimit();
        this.duration = movie.getDuration();
        this.description = movie.getDescription();
        this.imageUrl = movie.getImageUrl();
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
