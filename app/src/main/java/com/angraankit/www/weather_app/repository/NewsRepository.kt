package com.angraankit.www.weather_app.repository

import com.angraankit.www.weather_app.cache.news.NewsCacheMapper
import com.angraankit.www.weather_app.cache.news.NewsDao
import com.angraankit.www.weather_app.di.NewsKey
import com.angraankit.www.weather_app.model.News
import com.angraankit.www.weather_app.model.Weather
import com.angraankit.www.weather_app.network.news.NewsNetworkMapper
import com.angraankit.www.weather_app.network.news.NewsService
import com.angraankit.www.weather_app.network.weather.WeatherService
import com.angraankit.www.weather_app.utill.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

import javax.inject.Inject

class NewsRepository
@Inject
constructor(
    private val newsService: NewsService,
    private val newsNetworkMapper: NewsNetworkMapper,
    private val newsDao: NewsDao,
    private val newsCacheMapper: NewsCacheMapper,
    @NewsKey private val apiKey : String
) {
    suspend fun getNews (
        city : String
    ) : Flow<DataState<List<News>?>> = flow  {

        try {
            val networkNews = newsService.getNews(
                query = city,
                apiKey = apiKey
            )
            newsNetworkMapper.mapFromEntityList(networkNews)?.let {
                emit(DataState.Success(it))
            } ?: emit(DataState.Success(arrayListOf()))
        } catch (e : Exception) {
            emit(DataState.Error(e))
        }
    }
}