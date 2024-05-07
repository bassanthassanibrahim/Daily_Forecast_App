package com.example.dailyforecast.di

import android.app.Application
import androidx.room.Room
import com.example.dailyforecast.data.dto.local.data_base.DailyForecastDao
import com.example.dailyforecast.data.dto.local.data_base.DailyForecastDataBase
import com.example.dailyforecast.data.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDataBase(application: Application): DailyForecastDataBase =
        Room.databaseBuilder(
            application,
            DailyForecastDataBase::class.java,
            Constant.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideDao(dailyForecastDataBase: DailyForecastDataBase): DailyForecastDao =
        dailyForecastDataBase.getDailyForecastDao()
}

