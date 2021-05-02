package com.angraankit.www.weather_app.model

data class Story (
    val id : String?,
    val title : String?,
    val user : User?,
    val cover : String?
)

data class User (
    val name : String?,
    val avatar : String?,
    val fullname : String?
)