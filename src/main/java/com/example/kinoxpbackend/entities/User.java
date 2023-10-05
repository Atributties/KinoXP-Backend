package com.example.kinoxpbackend.entities;

import com.example.kinoxpbackend.enums.Roles;
import jakarta.persistence.*;

@Entity
public class User {



    private String name;
    @Enumerated(EnumType.STRING)
    private Roles role;
    private String password;
    @Id
    private String email;
    private int phoneNumber;


    @OneToOne(mappedBy = "user")
    private Reservation reservation;

    public User() {
    }

    public User(String name, Roles role, String password, String email, int phoneNumber) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
