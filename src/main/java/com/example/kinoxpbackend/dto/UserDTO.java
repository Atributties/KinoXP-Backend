package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.entities.User;
import com.example.kinoxpbackend.enums.Roles;

import java.util.Optional;


public class UserDTO {
    private int id;
    private String name;
    private Roles role;
    private String password;
    private String email;
    private String phoneNumber;
    private ReservationDTO reservation;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.role = user.getRole();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.reservation = new ReservationDTO(user.getReservation());

    }

    public UserDTO (String email, String password) {
        this.email = email;
        this.password = password;
    }



    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ReservationDTO getReservation() {
        return reservation;
    }

    public void setReservation(ReservationDTO reservation) {
        this.reservation = reservation;
    }
}