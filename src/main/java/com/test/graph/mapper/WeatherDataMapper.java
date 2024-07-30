package com.test.graph.mapper;

import com.test.graph.dto.HourlyDTO;
import com.test.graph.dto.WeatherApiResponseDTO;
import com.test.graph.dto.WeatherDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring")
public interface WeatherDataMapper {

    @Mapping(target = "times", source = "hourly")
    @Mapping(target = "temperatures", source = "hourly")
    WeatherDataDTO apiResponseToWeatherData(WeatherApiResponseDTO dto);

    default List<BigDecimal> mapHourlyToTemperatures(HourlyDTO hourly) {
        if (hourly == null) {
            return null;
        }
        return hourly.getTemperature_2m();
    }

    default List<String> mapHourlyToTimes(HourlyDTO hourly) {
        if (hourly == null) {
            return null;
        }
        return hourly.getTime();
    }
}
