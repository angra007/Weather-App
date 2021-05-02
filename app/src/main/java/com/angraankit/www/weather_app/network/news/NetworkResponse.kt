package com.angraankit.www.weather_app.network.news

import com.google.gson.annotations.SerializedName

data class NetworkNews (
    @SerializedName("totalResults")
    val totalResult : Int,
    @SerializedName("articles")
    val articles: List <NewtorkArticles>
)

data class NewtorkArticles (
    @SerializedName("title")
    val title : String?,
    @SerializedName("description")
    val description : String?,
    @SerializedName("url")
    val url : String?
)