package com.example.dailyforecast.domain.entity

data class City(
    val id: Int,
    val cityNameAr: String,
    val cityNameEn: String,
    val lat: Double,
    val lon: Double
)
