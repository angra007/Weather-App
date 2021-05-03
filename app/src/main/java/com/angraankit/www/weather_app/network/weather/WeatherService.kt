package com.angraankit.www.weather_app.network.weather

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getWeather (
        @Query ("q") query : String,
        @Query ("appid") appId : String
    ) : WeatherResponse

    @GET("forecast")
    suspend fun getForecast (
        @Query ("q" ) query : String,
        @Query ("appid") appId : String
    ) : ForecastResponse

}