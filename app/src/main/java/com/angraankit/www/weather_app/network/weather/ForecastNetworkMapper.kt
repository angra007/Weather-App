package com.angraankit.www.weather_app.network.weather

import com.angraankit.www.weather_app.model.Weather
import com.angraankit.www.weather_app.utill.EntityMapper
import javax.inject.Inject

class ForecastNetworkMapper
    @Inject
    constructor()
    : EntityMapper<ForecastResponse, List <Weather>> {
    override fun getEntityFromModel(model: List <Weather>): ForecastResponse? {

        val allForecast = mutableListOf<ForecastList>()

        model.forEach {weather ->
            val networkWeather = NetworkWeather(
                icon = weather.iconId
            )

            val networkMain = NetworkMain (
                temp = weather.temp,
                temp_max = weather.maxTemp,
                temp_min =  weather.minTemp
            )

            val forecastList = ForecastList (
                main = networkMain,
                weather = arrayListOf(networkWeather)
            )

            allForecast.add(forecastList)
        }

        return ForecastResponse (
            list = allForecast
        )
    }

    override fun getModelFromEntity(model: ForecastResponse): List <Weather> {
        val allForecast = mutableListOf<Weather>()
        model.list?.forEach {forecast ->
            val weather = Weather(
                iconId = forecast.weather?.first()?.icon,
                minTemp = forecast.main?.temp,
                maxTemp = forecast.main?.temp_max,
                temp = forecast.main?.temp
            )
            allForecast.add(weather)
        }
        return allForecast
    }
}