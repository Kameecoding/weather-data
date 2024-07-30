package com.test.graph.service.web.api;

import com.test.graph.dto.WeatherDataDTO;
import com.test.graph.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GraphController {

    private final WeatherService weatherService;

    @GetMapping(
            value = "/weather-data"
    )
    ResponseEntity<WeatherDataDTO> getWeatherData() {
        return ResponseEntity.ok(weatherService.getWeatherData());
    }
}
