package com.citymanagementsystem.city;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
