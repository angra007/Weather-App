package com.angraankit.www.weather_app.di

import android.content.Context
import androidx.room.Room
import com.angraankit.www.weather_app.cache.news.NewsDao
import com.angraankit.www.weather_app.cache.StoriesDatabase
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
    fun provideStoriesDb (@ApplicationContext context: Context) : StoriesDatabase {
        return Room.databaseBuilder (
            context,
            StoriesDatabase::class.java,
            StoriesDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideStoriesDao (stroriesDatabase: StoriesDatabase) : NewsDao {
        return stroriesDatabase.storiesDao()
    }
}