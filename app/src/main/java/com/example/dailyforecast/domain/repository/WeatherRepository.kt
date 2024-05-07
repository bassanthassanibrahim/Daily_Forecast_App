package com.example.dailyforecast.domain.repository

import com.example.dailyforecast.data.utils.DailyForcastEnum
import com.example.dailyforecast.domain.entity.City
import com.example.dailyforecast.domain.entity.WeatherItem

interface WeatherRepository {
    suspend fun getDailyForecast(lat: Double, long: Double): Pair<List<WeatherItem>,DailyForcastEnum>
    suspend fun getDailyForecastFromNetwork(lat: Double, long: Double): List<WeatherItem>?
    suspend fun insertAllDailyForecastToLocal(dailyForecast: List<WeatherItem>)
    suspend fun getDailyForecastFromLocal(lat: Double, lon: Double): List<WeatherItem>
    suspend fun getCities(): List<City>

}