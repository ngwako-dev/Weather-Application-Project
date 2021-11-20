package com.e.weatherservice.model.db.unitlocalized

import androidx.room.ColumnInfo

 data class ImperialCurrentWeatherEntry(
    override val temperature: Double,
    override val windSpeed: Double,
    override val windDirection: String,
    override val precipitationVolume: Double,
    override val feelsLikeTemperature: Double,
    override val visibilityDistance: Double

):UnitSpecificCurrentWeatherEntry