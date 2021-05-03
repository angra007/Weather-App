package com.angraankit.www.weather_app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angraankit.www.weather_app.repository.NewsRepository
import com.angraankit.www.weather_app.repository.WeatherRepository
import com.angraankit.www.weather_app.utill.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel
    @Inject
    constructor(
        private val weatherRepository: WeatherRepository,
        private val newsRepository: NewsRepository
    ) : ViewModel() {


    fun setStateEvent (mainStateEvent: MainStateEvent, city : String) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetWeather -> {
                    weatherRepository.getWeather(city)
                        .onEach {
                            System.out.println(it)
                        }
                        .launchIn(viewModelScope)
                }

                is MainStateEvent.GetForecast -> {
                    weatherRepository.getForecast(city)
                        .onEach {
                            System.out.println(it)
                        }.launchIn(viewModelScope)
                }

                is MainStateEvent.GetNews -> {
                    newsRepository.getNews(city)
                        .onEach {
                            System.out.println(it)
                        }.launchIn(viewModelScope)
                }
            }
        }
    }
}

sealed class MainStateEvent {
    object GetWeather : MainStateEvent()
    object GetForecast : MainStateEvent()
    object GetNews : MainStateEvent()
}



