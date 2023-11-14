package com.citymanagementsystem.city;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public Iterable<City> list() {
        return this.cityService.list();
    }

    @PostMapping("/cities")
    City newCity(@RequestBody City newCity) {
        return this.cityService.save(newCity);
    }
}
