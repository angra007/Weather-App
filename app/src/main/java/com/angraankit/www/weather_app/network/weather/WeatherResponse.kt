package com.angraankit.www.weather_app.network.weather

import com.google.gson.annotations.SerializedName


data class WeatherResponse (
    @SerializedName("weather")
    val weather : List <NetworkWeather?>,

    @SerializedName("main")
    val main : NetworkMain
)

data class NetworkWeather (
    @SerializedName("icon")
    val icon : String?
)

data class NetworkMain (
    @SerializedName("temp")
    val temp : String?,

    @SerializedName("temp_min")
    val temp_min : String?,

    @SerializedName("temp_max")
    val temp_max : String?
)
