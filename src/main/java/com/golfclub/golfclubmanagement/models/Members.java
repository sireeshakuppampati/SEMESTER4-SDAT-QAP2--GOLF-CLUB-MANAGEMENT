package com.golfclub.golfclubmanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 100, message = "Name should be between 1 and 100 characters")
    private String name;

    @Column(name = "address")
    @NotNull(message = "Address cannot be null")
    private String address;

    @Column(name = "email")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "phone_number")
    @NotNull(message = "Phone number cannot be null")
    private String phoneNumber;

    @Column(name = "start_date")
    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;

    @Column(name = "duration")
    private int duration;

    // No-argument constructor (required by JPA)
    public Members() {
    }
//CONSTRUCTORS
    // Constructor with fields (optional)
    public Members(String name, String address, String email, String phoneNumber, LocalDate startDate, int duration) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.duration = duration;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
