package com.example.dailyforecast.di

import android.content.Context
import com.example.dailyforecast.DailyForecastApp
import com.example.dailyforecast.data.service.CityService
import com.example.dailyforecast.data.service.CityServiceImpl
import com.example.dailyforecast.data.service.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule{

   // private val context = DailyForecastApp.context

    @Provides
    @Singleton
    fun provideWeatherServices(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)

    @Provides
    @Singleton
    fun provideCityServices(@ApplicationContext context: Context): CityService =
        CityServiceImpl(context)

}