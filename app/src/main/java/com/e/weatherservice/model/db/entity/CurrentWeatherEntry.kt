package com.e.weatherservice.model.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    @SerializedName("observation_time")
    val observationTime: String,
    val temperature: Double,
    @SerializedName("weather_code")
    val weatherCode: Double,
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_dir")
    val windDir: String,
    val precip: Double,
    val feelslike: Double,
    @SerializedName("uv_index")
    val uvIndex: Double,
    val visibility: Double,
    @SerializedName("is_day")
    val isDay: String
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}