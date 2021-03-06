package com.e.weatherservice.model.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}