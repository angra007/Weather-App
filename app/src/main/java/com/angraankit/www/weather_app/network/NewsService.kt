package com.angraankit.www.weather_app.network

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything")
    suspend fun getNews (
        @Query("q") query : String,
        @Query("apiKey") apiKey : String,
    )

}