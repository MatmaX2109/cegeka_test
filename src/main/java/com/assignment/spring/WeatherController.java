package com.assignment.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
@RestController
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/weather")
    public WeatherEntity weather(HttpServletRequest request) {
       return weatherService.weather(request.getParameter("city"));
    }


    @GetMapping(value = "/weather/{city}")
    public WeatherEntity weather(@PathVariable String city) {
        return weatherService.weather(city);
    }
}
