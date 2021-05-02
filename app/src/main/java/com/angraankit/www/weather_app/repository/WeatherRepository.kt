package com.angraankit.www.weather_app.repository

import com.angraankit.www.weather_app.di.WeatherKey
import com.angraankit.www.weather_app.network.weather.WeatherNetworkMapper
import com.angraankit.www.weather_app.network.weather.WeatherService
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(
    private val weatherService: WeatherService,
    private val weatherNetworkMapper: WeatherNetworkMapper,
    @WeatherKey private val apiKey : String
){
}