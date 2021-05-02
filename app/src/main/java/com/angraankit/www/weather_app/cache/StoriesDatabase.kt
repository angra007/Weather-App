package com.angraankit.www.weather_app.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.angraankit.www.weather_app.cache.news.NewsCacheEntity
import com.angraankit.www.weather_app.cache.news.NewsDao
import com.angraankit.www.weather_app.cache.news.UserCacheEntity

@Database(entities = [NewsCacheEntity::class, UserCacheEntity::class], version = 1, exportSchema = false)
abstract class StoriesDatabase : RoomDatabase() {

    abstract fun storiesDao() : NewsDao

    companion object {
        val DATABASE_NAME = "stories_db"
    }
}