package com.angraankit.www.weather_app.cache.news

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (newsCacheEntity: NewsCacheEntity) : Long

    @Query("SELECT * FROM stories")
    suspend fun getStories () : List<NewsCacheEntity>

    @Query("DELETE FROM stories")
    suspend fun deleteAll ()
}