package com.example.dailyforecast.di

import com.example.dailyforecast.data.dto.local.data_base.DailyForecastDao
import com.example.dailyforecast.data.service.CityService
import com.example.dailyforecast.data.service.WeatherService
import com.example.dailyforecast.domain.repository.WeatherRepository
import com.example.dailyforecast.domain.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDriverSettingsRepository(
        diaDailyForecastLocalDb: DailyForecastDao,
        cityService: CityService,
        weatherService: WeatherService
    ): WeatherRepository = WeatherRepositoryImpl(diaDailyForecastLocalDb, cityService, weatherService)

}