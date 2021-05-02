package com.angraankit.www.weather_app.di

import android.content.Context
import androidx.room.Room
import com.angraankit.www.weather_app.cache.news.NewsDao
import com.angraankit.www.weather_app.cache.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule  {

    @Provides
    @Singleton
    fun provideStoriesDb (@ApplicationContext context: Context) : WeatherDatabase {
        return Room.databaseBuilder (
            context,
            WeatherDatabase::class.java,
            WeatherDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideStoriesDao (stroriesDatabase: WeatherDatabase) : NewsDao {
        return stroriesDatabase.newsDao()
    }
}