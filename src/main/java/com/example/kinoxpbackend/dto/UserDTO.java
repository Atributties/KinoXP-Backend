package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.entities.User;

public class UserDTO {
    private int id;
    private String name;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();

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


}