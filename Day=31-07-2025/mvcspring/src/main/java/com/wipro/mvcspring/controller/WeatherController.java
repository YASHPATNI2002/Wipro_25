package com.wipro.mvcspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/weather")
    public String getWeather(
            @RequestParam(defaultValue = "Mumbai") String city,
            @RequestParam(defaultValue = "today") String day
    ) {
        String normalizedDay = day.toLowerCase();

        String weather;
        switch (normalizedDay) {
            case "today":
                weather = "sunny";
                break;
            case "tomorrow":
                weather = "cloudy";
                break;
            case "weekend":
                weather = "rainy";
                break;
            default:
                weather = "unknown"; 
                break;
        }

        return "Weather in " + city + " for " + day + " is " + weather + ".";
    }

    // Added method to handle /tocentigrade/{fahrenheit}
    @GetMapping("/tocentigrade/{fahrenheit}")
    public String convertFahrenheitToCentigrade(@PathVariable int fahrenheit) {
        int centigrade = (int) ((fahrenheit - 32) * 5 / 9.0);
        return fahrenheit + " Fahrenheit is " + centigrade + " Centigrade.";
    }
}
