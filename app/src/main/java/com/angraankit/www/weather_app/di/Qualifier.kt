package com.angraankit.www.weather_app.di

import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherKey

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NewsKey

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherRetrofitBuilder

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NewsRetrofitBuilder


