package com.e.weatherservice.model.network

import androidx.lifecycle.LiveData
import com.e.weatherservice.model.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}