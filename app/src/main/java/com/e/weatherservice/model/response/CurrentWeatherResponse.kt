package com.e.weatherservice.model.response


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val request: Request,
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: Current
)