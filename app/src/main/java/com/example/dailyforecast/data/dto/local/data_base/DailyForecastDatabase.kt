package com.example.dailyforecast.data.dto.local.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dailyforecast.data.dto.local.model.RoomConverter
import com.example.dailyforecast.data.dto.local.model.WeatherItemEntity

@Database(entities = [WeatherItemEntity::class], version = 2)
@TypeConverters(RoomConverter::class)
abstract class DailyForecastDataBase : RoomDatabase() {
    abstract fun getDailyForecastDao(): DailyForecastDao

}