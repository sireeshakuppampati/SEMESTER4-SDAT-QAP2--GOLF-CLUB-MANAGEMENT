package com.golfclub.golfclubmanagement.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "location")
    private String location;

    @Column(name = "entry_fee")
    private double entryFee;

    @Column(name = "cash_prize")
    private double cashPrize;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }
    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getCashPrize() {
        return cashPrize;
    }
    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }
}
