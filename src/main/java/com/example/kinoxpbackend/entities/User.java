package com.example.kinoxpbackend.entities;

import com.example.kinoxpbackend.enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Roles role;
    private String password;
    private String email;
    private String phoneNumber;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public User() {
    }

    public User(String name, Roles role, String password, String email, String phoneNumber) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(int id) {
        this.id = id;
    }

}
