package com.e.weatherservice.model.db.unitlocalized

class MetricCurrentWeatherEntry(
    override val visibilityDistance: Double,
    override val temperature: Double,
    override val windSpeed: Double,
    override val windDirection: String,
    override val precipitationVolume: Double,
    override val feelsLikeTemperature: Double

):UnitSpecificCurrentWeatherEntry