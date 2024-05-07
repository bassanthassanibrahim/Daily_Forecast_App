package com.example.dailyforecast.data.service

import com.example.dailyforecast.domain.entity.City

interface CityService {
    suspend fun getCities(): List<City>
}