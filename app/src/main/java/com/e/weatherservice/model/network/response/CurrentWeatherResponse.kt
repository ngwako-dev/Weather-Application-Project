package com.e.weatherservice.model.network.response


import com.e.weatherservice.model.db.entity.CurrentWeatherEntry
import com.e.weatherservice.model.db.entity.Location
import com.e.weatherservice.model.db.entity.Request
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val request: Request,
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntryWeatherEntry: CurrentWeatherEntry
)