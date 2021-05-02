package com.angraankit.www.weather_app.network.weather

import com.google.gson.annotations.SerializedName

data class ForecastResponse (
    @SerializedName("list")
    val list : List<ForecastList>?
)

data class ForecastList (
    @SerializedName("main")
    val main: NetworkMain?,
    @SerializedName("weather")
    val weather : List<NetworkWeather>?
)