package com.angraankit.www.weather_app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @WeatherKey
    fun provideWeatherKey () : String {
        return ""
    }

    @Singleton
    @Provides
    @NewsKey
    fun provideNetworkKey () : String {
        return ""
    }
}