package com.citymanagementsystem.city;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Entity
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double area; // in miles
    private long population;
    private double density; // population per aria in square km

    public City() {}
}
