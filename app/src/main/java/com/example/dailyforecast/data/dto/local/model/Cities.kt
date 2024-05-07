package com.example.dailyforecast.data.dto.local.model

data class Cities(
    val cities: List<CityEntity>
)
data class CityEntity(
    val id: Int,
    val cityNameAr: String,
    val cityNameEn: String,
    val lat: Double,
    val lon: Double
)