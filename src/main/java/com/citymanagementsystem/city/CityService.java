package com.citymanagementsystem.city;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final String ASCENDING_DIRECTION = "asc";
    private final double MILE_TO_KM_COEFFICIENT = 1.609344;
    private final CityCrudRepository cityCrudRepository;
    private final CityJpaRepository cityJpaRepository;

    public CityService(CityCrudRepository cityCrudRepository, CityJpaRepository cityJpaRepository) {
        this.cityCrudRepository = cityCrudRepository;
        this.cityJpaRepository = cityJpaRepository;
    }

    public Iterable<City> list(Optional<String> field, Optional<String> orderDir, Optional<String> filter) {
        if (field.isPresent() && orderDir.isPresent()) {
            return orderDir.get().equals(ASCENDING_DIRECTION) ? this.findAllCitiesSortedAscending(field.get()) : this.findAllCitiesSortedDescending(field.get());
        }
        if (filter.isPresent()) {
            return this.findByNameContaining(filter.get());
        }
        return this.cityCrudRepository.findAll();
    }

    public Iterable<City> saveAll(List<City> cities) {
        calculateAndSetDensity(cities);
        return cityCrudRepository.saveAll(cities);
    }

    public City save(City city) {
        calculateAndSetDensity(city);
        return cityCrudRepository.save(city);
    }

    public Iterable<City> findAllCitiesSortedAscending(String field) {
        return this.cityJpaRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Iterable<City> findAllCitiesSortedDescending(String field) {
        return this.cityJpaRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public Iterable<City> findByNameContaining(String name) {
        return this.cityJpaRepository.findByNameContainingIgnoreCase(name);
    }

    private void calculateAndSetDensity(List<City> cityList) {
        cityList.forEach(this::calculateAndSetDensity);
    }

    private void calculateAndSetDensity(City city) {
        city.setDensity(city.getPopulation() / (city.getArea() * MILE_TO_KM_COEFFICIENT));
    }
}
