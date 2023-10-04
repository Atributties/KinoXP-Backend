package com.example.kinoxpbackend.config;

import com.example.kinoxpbackend.enums.AgeLimit;
import com.example.kinoxpbackend.enums.MovieCategories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumConfig {

    @Bean
    public AgeLimit[] ageLimit() {
        return AgeLimit.values(); // Assuming AgeLimit is an enum
    }

    @Bean
    public MovieCategories[] movieCategories() {
        return MovieCategories.values(); // Assuming MovieCategories is an enum
    }
}