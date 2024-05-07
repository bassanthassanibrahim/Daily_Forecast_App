package com.example.dailyforecast.data.service


import com.example.dailyforecast.data.dto.remote.DailyForecastDto
import com.example.dailyforecast.data.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/forecast?")
    suspend fun getDailyForecast(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
        @Query("appid") appId: String =  Constant.API_KEY
    ): DailyForecastDto
}