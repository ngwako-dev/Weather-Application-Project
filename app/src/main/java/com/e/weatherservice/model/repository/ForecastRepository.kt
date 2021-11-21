package com.e.weatherservice.model.repository

import androidx.lifecycle.LiveData
import com.e.weatherservice.model.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
}