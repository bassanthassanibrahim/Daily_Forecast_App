package com.example.dailyforecast.presentation.ui

import com.example.dailyforecast.domain.entity.City
import com.example.dailyforecast.domain.entity.WeatherItem

fun List<WeatherItem>.toUiState(): List<WeatherItemUiState> {
    return this.map { weatherItem ->
        WeatherItemUiState(
            weatherDescription = weatherItem.weather.firstOrNull()?.description ?: "",
            temperature = "${weatherItem.weatherInfo.temperature}°C", // Assuming temperature is in Celsius
            weatherIcon = weatherItem.weather.firstOrNull()?.icon
                ?: "",
            day = weatherItem.dateText, // Assuming dateText represents the day
            windSpeed = "${weatherItem.windSpeed} m/s" // Assuming wind speed is in meters per second
        )
    }
}

fun City.toUiState(): CityUiState {
    return CityUiState(
        id = id,
        cityNameAr = cityNameAr,
        cityNameEn = cityNameEn,
        lat = lat,
        lon = lon
    )
}