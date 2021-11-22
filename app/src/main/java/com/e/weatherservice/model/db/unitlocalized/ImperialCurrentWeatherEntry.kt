package com.e.weatherservice.model.db.unitlocalized

import androidx.room.ColumnInfo

 data class ImperialCurrentWeatherEntry(
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double,
    override val windSpeed: Double,
    @ColumnInfo(name = "windDir")
    override val windDirection: String,
    @ColumnInfo(name = "precip")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Double

 ):UnitSpecificCurrentWeatherEntry