package com.golfclub.golfclubmanagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Golf Club Management System! Use the API endpoints to manage members and tournaments.";
    }
}
