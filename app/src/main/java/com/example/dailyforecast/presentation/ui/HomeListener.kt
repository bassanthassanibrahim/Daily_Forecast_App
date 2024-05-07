package com.example.dailyforecast.presentation.ui

interface HomeListener {
    fun onCitySelected(lat: Double, long: Double, cityName: String)
    fun onRetryClicked()
}