package com.angraankit.www.weather_app.network

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getWeather (
        @Query ("q") query : String,
        @Query ("appid") appId : String
    )

    suspend fun getForecast (
        @Query ("q" ) query : String,
        @Query ("appid") appId : String
    )

}