package com.angraankit.www.weather_app.di

import com.angraankit.www.weather_app.network.news.NewsService
import com.angraankit.www.weather_app.network.weather.WeatherService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule  {

    @Singleton
    @Provides
    fun provideGsonBuilder () : Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    @WeatherRetrofitBuilder
    fun provideWeatherRetrofit (gson: Gson) : Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    @NewsRetrofitBuilder
    fun provideNewsRetrofit (gson: Gson) : Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideStoriesService (@WeatherRetrofitBuilder retrofit: Retrofit.Builder) : WeatherService {
        return retrofit
            .build()
            .create(WeatherService::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkService (@NewsRetrofitBuilder retrofit: Retrofit.Builder) : NewsService {
        return retrofit
            .build()
            .create(NewsService::class.java)
    }

}