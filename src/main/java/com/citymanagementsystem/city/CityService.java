package com.citymanagementsystem.city;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityCrudRepository cityCrudRepository;

    public CityService(CityCrudRepository cityCrudRepository) {
        this.cityCrudRepository = cityCrudRepository;
    }

    public Iterable<City> list() {
        return this.cityCrudRepository.findAll();
    }

    public Iterable<City> saveAll(List<City> cities) {
        return cityCrudRepository.saveAll(cities);
    }
}
