package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.entities.Showtime;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowtimeDTO {
    private int id;
    private LocalDate date;
    private LocalTime time;


    public ShowtimeDTO(Showtime showtime) {
        this.id = showtime.getId();
        this.date = showtime.getDate();
        this.time = showtime.getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
