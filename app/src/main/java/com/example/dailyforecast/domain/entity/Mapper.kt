package com.example.dailyforecast.domain.entity

import com.example.dailyforecast.data.dto.local.model.WeatherEntity
import com.example.dailyforecast.data.dto.local.model.WeatherInfoEntity
import com.example.dailyforecast.data.dto.local.model.WeatherItemEntity

fun WeatherItem.toLocalEntity(): WeatherItemEntity {
    return WeatherItemEntity(
        weatherInfo = weatherInfo.toLocalEntity(),
        weather = weather.map { it.toLocalEntity() },
        cloud = cloud,
        windSpeed = windSpeed,
        dateText = dateText,
        lat = lat,
        lon = lon
    )
}
fun List<WeatherItem>.toLocalEntity(): List<WeatherItemEntity> {
    return map { it.toLocalEntity() }
}

fun WeatherInfo.toLocalEntity(): WeatherInfoEntity {
    return WeatherInfoEntity(
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

fun Weather.toLocalEntity(): WeatherEntity {
    return WeatherEntity(
        id = id,
        description = description,
        icon = icon
    )
}