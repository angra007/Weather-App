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
        return "99b00db2e67a4e43bbec04380469ec7c"
    }

    @Singleton
    @Provides
    @NewsKey
    fun provideNewsKey () : String {
        return ""
    }
}