package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.entities.Seat;
import com.example.kinoxpbackend.entities.Showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowtimeDTO {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private String theaterName;
    private MovieDTO movie; // Tilføj en MovieDTO-felt
    private List<SeatDTO> seatDTOS;

    public ShowtimeDTO(Showtime showtime) {
        this.id = showtime.getId();
        this.date = showtime.getDate();
        this.time = showtime.getTime();
        this.theaterName = String.valueOf(showtime.getTheater().getTheaterName());

        // Opret en MovieDTO baseret på Showtime's tilknyttede film
        if (showtime.getMovie() != null) {
            this.movie = new MovieDTO(showtime.getMovie());
        }

        // Kopier seatDTOs fra Showtime til ShowtimeDTO
        this.seatDTOS = new ArrayList<>();
        for (Seat seat : showtime.getSeats()) {
            this.seatDTOS.add(new SeatDTO(seat));
        }

    }

    public List<SeatDTO> getSeatDTOS() {
        return seatDTOS;
    }

    public void setSeatDTOS(List<SeatDTO> seatDTOS) {
        this.seatDTOS = seatDTOS;
    }

    // Tilføj getter og setter for movie-feltet
    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
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

    // Getter for teaternavnet
    public String getTheaterName() {
        return theaterName;
    }

    // Setter for teaternavnet, hvis det er relevant
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
}
