package com.angraankit.www.weather_app.repository

import com.angraankit.www.weather_app.di.WeatherKey
import com.angraankit.www.weather_app.model.Weather
import com.angraankit.www.weather_app.network.weather.ForecastNetworkMapper
import com.angraankit.www.weather_app.network.weather.WeatherNetworkMapper
import com.angraankit.www.weather_app.network.weather.WeatherService
import com.angraankit.www.weather_app.utill.DataState
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(
    private val weatherService: WeatherService,
    private val weatherNetworkMapper: WeatherNetworkMapper,
    private val forecastNetworkMapper: ForecastNetworkMapper,
    @WeatherKey private val apiKey : String
){

    suspend fun getForecast (
        city: String
    ) : Flow<DataState<List<Weather>>> = flow {
        try {
            val weathers : List <Weather>
            withContext(IO) {
                val foreCastResponse = weatherService.getForecast(
                    query = city,
                    appId = apiKey
                )
                weathers = forecastNetworkMapper.getModelFromEntity(foreCastResponse)
            }
            emit(DataState.Success(weathers))
        } catch ( e : Exception) {
            emit(DataState.Error(e))
        }
    }

    suspend fun getWeather (
        city : String
    ) : Flow<DataState<Weather>> = flow {
        try {
            var weather : Weather
            withContext(IO) {
                val networkWeather = weatherService.getWeather(
                    query = city,
                    appId = apiKey)
                weather= weatherNetworkMapper.getModelFromEntity(networkWeather)
            }
            emit(DataState.Success(weather))

        } catch ( e : Exception) {
            emit(DataState.Error(e))
        }
    }

}