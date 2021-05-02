package com.angraankit.www.weather_app.repository

import com.angraankit.www.weather_app.cache.news.NewsCacheMapper
import com.angraankit.www.weather_app.cache.news.NewsDao
import com.angraankit.www.weather_app.model.Story
import com.angraankit.www.weather_app.network.weather.WeatherNetworkMapper
import com.angraankit.www.weather_app.network.weather.WeatherService
import com.angraankit.www.weather_app.utill.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class MainRepository
@Inject
constructor(
    private val newsDao: NewsDao,
    private val weatherService: WeatherService,
    private val weatherNetworkMapper: WeatherNetworkMapper,
    private val newsCacheMapper: NewsCacheMapper
){
    suspend fun getStories () : Flow<DataState<List<Story>>> = flow {

        val cacheStories = newsDao.getStories()
        emit(DataState.Loading(newsCacheMapper.mapFromEntityList(cacheStories)))

        try {

//            withContext(IO) {
//                val networkStories = weatherService.getStories(
//                    offset = "0",
//                    limit = "10",
//                    fields = "stories(id,title,cover,user)",
//                    filter = "new"
//                )
//
//                storiesDao.deleteAll()
//
//                val stories = storiesNetworkMapper.mapFromEntityList(networkStories)
//                stories?.forEach {
//                    storiesCacheMapper.getEntityFromModel(it)?.let {storyCacheEntity ->
//                        storiesDao.insert(storyCacheEntity)
//                    }
//                }
//            }

            emit(DataState.Success(newsCacheMapper.mapFromEntityList(newsDao.getStories())))

        } catch (e : Exception) {
            emit(DataState.Error(e))
        }
    }
}