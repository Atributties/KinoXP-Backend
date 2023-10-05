package com.example.kinoxpbackend.controller;


import com.example.kinoxpbackend.service.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EnumController {


    @Autowired
    private EnumService enumService;


    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categories = enumService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/age-limits")
    public ResponseEntity<List<String>> getAllAgeLimits() {
        List<String> ageLimits = enumService.getAllAgeLimits();
        return new ResponseEntity<>(ageLimits, HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<String>> getAllRoles() {
        List<String> roles = enumService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}

