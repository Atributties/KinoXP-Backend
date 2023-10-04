package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.enums.AgeLimit;
import com.example.kinoxpbackend.enums.MovieCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnumService {

    private final AgeLimit[] ageLimits;
    private final MovieCategories[] movieCategories;

    @Autowired
    public EnumService(AgeLimit[] ageLimits, MovieCategories[] movieCategories) {
        this.ageLimits = ageLimits;
        this.movieCategories = movieCategories;
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
}