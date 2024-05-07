package com.example.dailyforecast

import android.annotation.SuppressLint
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DailyForecastApp: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        //context = applicationContext
    }
    override
    fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {

//        @SuppressLint("StaticFieldLeak")
//        lateinit  var context: Context
//            private set

    }

}