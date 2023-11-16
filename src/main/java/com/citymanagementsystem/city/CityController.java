package com.citymanagementsystem.city;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public Iterable<City> list(@RequestParam(required = false) Optional<String> sortBy, @RequestParam(required = false) Optional<String> orderDir, @RequestParam(required = false) Optional<String> filter) {
        return this.cityService.list(sortBy, orderDir, filter);
    }

    @PostMapping("/cities")
    public City newCity(@RequestBody City newCity) {
        return this.cityService.save(newCity);
    }
}
