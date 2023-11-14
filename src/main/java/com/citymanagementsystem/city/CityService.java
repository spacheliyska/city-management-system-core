package com.citymanagementsystem.city;

import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityCrudRepository cityCrudRepository;

    public CityService(CityCrudRepository cityCrudRepository) {
        this.cityCrudRepository = cityCrudRepository;
    }

    public Iterable<City> list() {
        return this.cityCrudRepository.findAll();
    }
}
