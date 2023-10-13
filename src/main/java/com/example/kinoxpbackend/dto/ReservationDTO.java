package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.entities.Reservation;
import com.example.kinoxpbackend.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationDTO {
    private int id;
    private User user;
    private ShowtimeDTO showtime;
    private List<SeatReservationDTO> seatReservations;

    // Existing constructor for fetching an existing reservation
    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();
        this.user = reservation.getUser();
        this.showtime = new ShowtimeDTO(reservation.getShowtime());

        // Map hver SeatReservation til SeatReservationDTO
        this.seatReservations = reservation.getSeatReservations().stream()
                .map(SeatReservationDTO::new)
                .collect(Collectors.toList());
    }
    // Getter og setter metoder her (kan være nødvendige afhængigt af dine behov)


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShowtimeDTO getShowtime() {
        return showtime;
    }

    public void setShowtime(ShowtimeDTO showtime) {
        this.showtime = showtime;
    }

    public List<SeatReservationDTO> getSeatReservations() {
        return seatReservations;
    }

    public void setSeatReservations(List<SeatReservationDTO> seatReservations) {
        this.seatReservations = seatReservations;
    }
}