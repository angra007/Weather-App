package com.angraankit.www.weather_app.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.angraankit.www.weather_app.cache.news.NewsCacheEntity
import com.angraankit.www.weather_app.cache.news.NewsDao

@Database(entities = [NewsCacheEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun newsDao() : NewsDao

    companion object {
        val DATABASE_NAME = "weather_db"
    }
}