package com.example.androidcomposemarvel.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite_comics")
    fun getAll(): Flow<List<FavoriteComic>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(fav: FavoriteComic)

    @Delete
    suspend fun delete(fav: FavoriteComic)
}
