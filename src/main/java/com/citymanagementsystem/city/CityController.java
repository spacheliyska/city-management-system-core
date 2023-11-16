package com.citymanagementsystem.city;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = "*")
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<Iterable<City>> list(@RequestParam(required = false) Optional<String> sortBy, @RequestParam(required = false) Optional<String> orderDir, @RequestParam(required = false) Optional<String> filter) {
        return new ResponseEntity<>(this.cityService.list(sortBy, orderDir, filter), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> newCity(@Valid @RequestBody City newCity) {
        City createdCity = this.cityService.save(newCity);
        return new ResponseEntity<>(createdCity, HttpStatus.CREATED);
    }
}
