package com.e.weatherservice.ui.weather.current

import androidx.lifecycle.ViewModel
import com.e.weatherservice.internal.UnitSystem
import com.e.weatherservice.internal.lazyDefered
import com.e.weatherservice.model.repository.ForecastRepository

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.IMPERIAL

    val isMetric: Boolean
    get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDefered {
        forecastRepository.getCurrentWeather(isMetric)
    }
}