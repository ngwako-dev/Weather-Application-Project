package com.e.weatherservice.model.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.e.weatherservice.internal.NoConnectivityException
import com.e.weatherservice.model.network.response.CurrentWeatherResponse

class WeatherNetworkDataSourceImpl(
    private val weatherAPiService: WeatherAPiService
) : WeatherNetworkDataSource {
    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchCurrentWeather = weatherAPiService
                .getCurrentWeather(location, languageCode)
                .await()
                _downloadedCurrentWeather.postValue(fetchCurrentWeather)
        }
        catch (e: NoConnectivityException){
            Log.e("Connectivity","No internet connection.", e)
        }
    }
}