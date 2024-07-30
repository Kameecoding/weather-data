package com.test.graph.service.impl;

import com.test.graph.dto.WeatherApiResponseDTO;
import com.test.graph.dto.WeatherDataDTO;
import com.test.graph.mapper.WeatherDataMapper;
import com.test.graph.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;
    private final WeatherDataMapper weatherDataMapper;

    @Override
    public WeatherDataDTO getWeatherData() {
        WeatherApiResponseDTO result = restTemplate.getForObject("https://api.open-meteo.com/v1/forecast?latitude=48.1482&longitude=17.1067&hourly=temperature_2m&forecast_days=1", WeatherApiResponseDTO.class);

        return weatherDataMapper.apiResponseToWeatherData(result);
    }
}
