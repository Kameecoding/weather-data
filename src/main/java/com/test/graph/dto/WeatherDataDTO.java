package com.test.graph.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class WeatherDataDTO {
    private List<String> times;
    private List<BigDecimal> temperatures;
}
