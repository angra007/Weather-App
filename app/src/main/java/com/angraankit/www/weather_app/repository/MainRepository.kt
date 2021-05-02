package com.angraankit.www.weather_app.repository

import com.angraankit.www.weather_app.cache.StoriesCacheMapper
import com.angraankit.www.weather_app.cache.StoriesDao
import com.angraankit.www.weather_app.model.Story
import com.angraankit.www.weather_app.network.StoriesNetworkMapper
import com.angraankit.www.weather_app.network.StoriesNetworkService
import com.angraankit.www.weather_app.utill.DataState
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class MainRepository
@Inject
constructor(
    private val storiesDao: StoriesDao,
    private val storiesNetworkService: StoriesNetworkService,
    private val storiesNetworkMapper: StoriesNetworkMapper,
    private val storiesCacheMapper: StoriesCacheMapper
){
    suspend fun getStories () : Flow<DataState<List<Story>>> = flow {

        val cacheStories = storiesDao.getStories()
        emit(DataState.Loading(storiesCacheMapper.mapFromEntityList(cacheStories)))

        try {

            withContext(IO) {
                val networkStories = storiesNetworkService.getStories(
                    offset = "0",
                    limit = "10",
                    fields = "stories(id,title,cover,user)",
                    filter = "new"
                )

                storiesDao.deleteAll()

                val stories = storiesNetworkMapper.mapFromEntityList(networkStories)
                stories?.forEach {
                    storiesCacheMapper.getEntityFromModel(it)?.let {storyCacheEntity ->
                        storiesDao.insert(storyCacheEntity)
                    }
                }
            }

            emit(DataState.Success(storiesCacheMapper.mapFromEntityList(storiesDao.getStories())))

        } catch (e : Exception) {
            emit(DataState.Error(e))
        }
    }
}