package com.citymanagementsystem.city;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityCrudRepository cityCrudRepository;
    private final CityJpaRepository cityJpaRepository;

    public CityService(CityCrudRepository cityCrudRepository, CityJpaRepository cityJpaRepository) {
        this.cityCrudRepository = cityCrudRepository;
        this.cityJpaRepository = cityJpaRepository;
    }

    public Iterable<City> list() {
        return this.cityCrudRepository.findAll();
    }

    public Iterable<City> saveAll(List<City> cities) {
        calculateDensity(cities);
        return cityCrudRepository.saveAll(cities);
    }

    public Iterable<City> findAllCitiesSortedAscending(String field) {
        return this.cityJpaRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Iterable<City> findAllCitiesSortedDescending(String field) {
        return this.cityJpaRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public Iterable<City> findByNameContaining(String name) {
        return this.cityJpaRepository.findByNameContaining(name);
    }

    private void calculateDensity(List<City> cityList) {
        cityList.forEach(city -> {
            city.setDensity(city.getPopulation() / city.getArea());
        });
    }
}
