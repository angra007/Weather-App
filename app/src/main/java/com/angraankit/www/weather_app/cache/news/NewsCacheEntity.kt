package com.angraankit.www.weather_app.cache.news

import androidx.room.*

@Entity(tableName = "Stories", indices = [Index(value = ["id"], unique = true)])
data class NewsCacheEntity (

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : String,

    @ColumnInfo(name = "title")
    var title : String?,

    @ColumnInfo(name = "description")
    var description : String?,

    @ColumnInfo(name = "url")
    var url : String?

)

