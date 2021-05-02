package com.angraankit.www.weather_app.repository

import com.angraankit.www.weather_app.cache.news.NewsCacheMapper
import com.angraankit.www.weather_app.cache.news.NewsDao
import com.angraankit.www.weather_app.network.news.NewsNetworkMapper
import com.angraankit.www.weather_app.network.news.NewsService
import com.angraankit.www.weather_app.network.weather.WeatherService
import javax.inject.Inject

class NewsRepository
@Inject
constructor(
    private val newsService: NewsService,
    private val newsNetworkMapper: NewsNetworkMapper,
    private val newsDao: NewsDao,
    private val newsCacheMapper: NewsCacheMapper
) {
}