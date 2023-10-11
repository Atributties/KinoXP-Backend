package com.example.kinoxpbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Definer de stier, hvor CORS skal aktiveres
                .allowedOrigins("http://localhost:63342") // Tillad anmodninger fra dette oprindelsessted
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Tilladte HTTP-metoder
                .allowedHeaders("*"); // Tilladte HTTP-overskrifter
    }
}
