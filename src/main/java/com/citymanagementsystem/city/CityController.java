package com.citymanagementsystem.city;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    private CityService cityService;

    @GetMapping("/cities")
    public Iterable<City> list() {
        return this.cityService.list();
    }
}
