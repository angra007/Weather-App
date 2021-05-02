package com.angraankit.www.weather_app.network

import retrofit2.http.GET
import retrofit2.http.Query

interface StoriesNetworkService {

    @GET("stories")
    suspend fun getStories (
        @Query("offset") offset : String,
        @Query("limit") limit : String,
        @Query("fields") fields : String,
        @Query("filter") filter : String
    ) : StoriesNetworkEntity

}