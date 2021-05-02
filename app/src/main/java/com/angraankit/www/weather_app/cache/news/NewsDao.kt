package com.angraankit.www.weather_app.cache.news

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (newsCacheEntity: NewsCacheEntity) : Long

    @Query("SELECT * FROM news")
    suspend fun getNews () : List<NewsCacheEntity>

    @Query("DELETE FROM news")
    suspend fun deleteAll ()
}