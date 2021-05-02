package com.angraankit.www.weather_app.network.weather

import com.angraankit.www.weather_app.model.Weather
import com.angraankit.www.weather_app.utill.EntityMapper
import javax.inject.Inject

class WeatherNetworkMapper
    @Inject constructor (
    ) : EntityMapper<WeatherResponse, Weather>{

    override fun getEntityFromModel(story: Weather): WeatherResponse {
        val networkWeather = NetworkWeather(
            icon = story.iconId
        )

        val networkMain = NetworkMain (
            temp = story.temp,
            temp_max = story.maxTemp,
            temp_min =  story.minTemp
        )

        val weatherList = arrayListOf(networkWeather)

        return WeatherResponse(
            weather = weatherList,
            main = networkMain
        )
    }

    override fun getModelFromEntity(model: WeatherResponse): Weather {
        return Weather(
            iconId = model.weather.first()?.icon,
            minTemp = model.main.temp,
            maxTemp = model.main.temp_max,
            temp = model.main.temp
        )
    }
}
