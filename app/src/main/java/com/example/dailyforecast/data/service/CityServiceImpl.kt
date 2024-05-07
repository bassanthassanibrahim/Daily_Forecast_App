package com.example.dailyforecast.data.service

import android.content.Context
import com.example.dailyforecast.data.dto.local.model.Cities
import com.example.dailyforecast.data.dto.local.model.toEntity
import com.example.dailyforecast.data.utils.Constant
import com.example.dailyforecast.domain.entity.City
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CityServiceImpl(private val context: Context) : CityService {
    override suspend fun getCities(): List<City> {
        return parseJsonToModel(
            readJsonFromAssets(
                context,
                Constant.FILE_NAME
            )
        ).cities.map { it.toEntity() }
    }

    private fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }

    private fun parseJsonToModel(jsonString: String): Cities {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<Cities>() {}.type)
    }

}