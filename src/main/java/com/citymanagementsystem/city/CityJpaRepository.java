package com.citymanagementsystem.city;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityJpaRepository extends JpaRepository<City, Long> {
    Iterable<City> findByNameContaining(String name);
}