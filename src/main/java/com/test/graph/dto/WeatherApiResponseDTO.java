package com.test.graph.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WeatherApiResponseDTO {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal generationtimeMs;
    private Integer utcOffsetSeconds;
    private String timezone;
    private String timezoneAbbreviation;
    private BigDecimal elevation;
    private HourlyUnitsDTO hourlyUnits;
    private HourlyDTO hourly;
}

