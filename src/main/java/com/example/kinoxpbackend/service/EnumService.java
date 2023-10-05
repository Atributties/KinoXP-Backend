package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.enums.AgeLimit;
import com.example.kinoxpbackend.enums.MovieCategories;
import com.example.kinoxpbackend.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnumService {

    private final AgeLimit[] ageLimits;
    private final MovieCategories[] movieCategories;
    private final Roles[] roles;

    @Autowired
    public EnumService(AgeLimit[] ageLimits, MovieCategories[] movieCategories, Roles[] roles) {
        this.ageLimits = ageLimits;
        this.movieCategories = movieCategories;
        this.roles = roles;
    }

    public List<String> getAllCategories() {
        return Arrays.stream(movieCategories)
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public List<String> getAllAgeLimits() {
        return Arrays.stream(ageLimits)
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public List<String> getAllRoles() {
        return Arrays.stream(roles)
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}