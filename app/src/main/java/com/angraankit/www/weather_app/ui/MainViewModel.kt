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

//    private val _datastate : MutableLiveData<DataState<List<Story>>> = MutableLiveData()
//    val dataState : LiveData<DataState<List<Story>>>
//        get() = _datastate

    fun setStateEvent (mainStateEvent: MainStateEvent) {
//        viewModelScope.launch {
//            when (mainStateEvent) {
//                is MainStateEvent.GetStories -> {
//                    mainRepository.getStories()
//                        .onEach { dataState ->
//                            _datastate.value = dataState
//                        }
//                        .launchIn(viewModelScope)
//                }
//            }
//        }
    }

}

sealed class MainStateEvent {
    object GetStories : MainStateEvent()
}



