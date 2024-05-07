package com.example.dailyforecast.data.dto.local.model

import com.example.dailyforecast.domain.entity.City
import com.example.dailyforecast.domain.entity.Weather
import com.example.dailyforecast.domain.entity.WeatherInfo
import com.example.dailyforecast.domain.entity.WeatherItem

fun WeatherItemEntity.toEntity(): WeatherItem {
    return WeatherItem(
        weatherInfo = weatherInfo.toEntity(),
        weather = weather.map { it.toEntity() },
        cloud =cloud,
        windSpeed = windSpeed,
        dateText = dateText,
        lat = lat,
        lon = lon
    )
}

fun List<WeatherItemEntity>.toEntity(): List<WeatherItem> {
    return map { it.toEntity() }
}

fun WeatherInfoEntity.toEntity(): WeatherInfo {
    return WeatherInfo(
        temperature = temperature,
        feelsTemperature = feelsTemperature,
        minimTemperature = minimTemperature,
        maximumTemperature = maximumTemperature,
        pressure = pressure,
        seaLevel = seaLevel,
        grandLevel = grandLevel,
        humidity = humidity,
        kelvinTemperature = kelvinTemperature
    )
}

fun WeatherEntity.toEntity(): Weather {
    return Weather(
        id = id,
        description = description,
        icon = icon
    )
}
fun CityEntity.toEntity(): City {
    return City(
        id = id,
        cityNameAr = cityNameAr,
        cityNameEn = cityNameEn,
        lat = lat,
        lon = lon
    )
}