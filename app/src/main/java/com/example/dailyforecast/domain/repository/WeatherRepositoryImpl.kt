package com.example.dailyforecast.domain.repository

import com.example.dailyforecast.data.dto.local.data_base.DailyForecastDao
import com.example.dailyforecast.data.dto.local.model.toEntity
import com.example.dailyforecast.data.dto.remote.toEntity
import com.example.dailyforecast.data.service.CityService
import com.example.dailyforecast.data.service.WeatherService
import com.example.dailyforecast.data.utils.DailyForcastEnum
import com.example.dailyforecast.domain.entity.City
import com.example.dailyforecast.domain.entity.WeatherItem
import com.example.dailyforecast.domain.entity.toLocalEntity
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val diaDailyForecastLocalDb: DailyForecastDao,
    private val cityService: CityService,
    private val weatherService: WeatherService
) : WeatherRepository{
    override suspend fun getDailyForecast(
        lat: Double,
        long: Double
    ): Pair<List<WeatherItem>, DailyForcastEnum> {
        val networkWeather = getDailyForecastFromNetwork(lat, long)
        return if (!networkWeather.isNullOrEmpty()) {
            insertAllDailyForecastToLocal(networkWeather)
            Pair(networkWeather, DailyForcastEnum.NETWORK)
        } else {
            val localWeather = getDailyForecastFromLocal(lat,long)
            Pair(localWeather, DailyForcastEnum.LOCAL)
        }
    }

    override suspend fun getDailyForecastFromNetwork(
        lat: Double,
        long: Double
    ): List<WeatherItem>? {
        return try {
            val weatherItems = weatherService.getDailyForecast(lat, long).toEntity()
            return weatherItems.distinctBy { it.dateText }
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun insertAllDailyForecastToLocal(dailyForecast: List<WeatherItem>) {
        diaDailyForecastLocalDb.insertAllDailyForecastToDb(
            dailyForecast.toLocalEntity()
        )
    }

    override suspend fun getDailyForecastFromLocal(lat: Double, lon: Double): List<WeatherItem> {
        return diaDailyForecastLocalDb.getDailyForecastFromDb(lat, lon).toEntity()
    }

    override suspend fun getCities(): List<City> {
        return cityService.getCities()
    }
}