package com.test.graph.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class HourlyDTO {

        private List<String> time;
        private List<BigDecimal> temperature_2m;
}
