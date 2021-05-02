package com.angraankit.www.weather_app.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StoriesCacheEntity::class, UserCacheEntity::class], version = 1, exportSchema = false)
abstract class StoriesDatabase : RoomDatabase() {

    abstract fun storiesDao() : StoriesDao

    companion object {
        val DATABASE_NAME = "stories_db"
    }
}