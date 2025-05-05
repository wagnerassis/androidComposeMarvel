package com.example.androidcomposemarvel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteComic::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
