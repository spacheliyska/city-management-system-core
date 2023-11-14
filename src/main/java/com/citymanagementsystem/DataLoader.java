package com.citymanagementsystem;

import com.citymanagementsystem.city.CityService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.citymanagementsystem.city.City;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private CityService cityService;

    public DataLoader(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<City>> typeReference = new TypeReference<>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/cities.json");

        try {
            List<City> cities = objectMapper.readValue(inputStream, typeReference);
            this.cityService.saveAll(cities);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON data", e);
        }
    }
}
