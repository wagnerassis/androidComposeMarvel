package com.example.androidcomposemarvel.di

import android.content.Context
import androidx.room.Room
import com.example.androidcomposemarvel.data.api.ApiClient
import com.example.androidcomposemarvel.data.api.MarvelApiService
import com.example.androidcomposemarvel.data.local.AppDatabase
import com.example.androidcomposemarvel.data.local.FavoriteDao
import com.example.androidcomposemarvel.domain.repository.MarvelRepository
import com.example.androidcomposemarvel.domain.repository.MarvelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMarvelApiService(): MarvelApiService =
        ApiClient.createService()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()

    @Provides
    fun provideFavoriteDao(db: AppDatabase): FavoriteDao =
        db.favoriteDao()

    @Provides
    @Singleton
    fun provideMarvelRepository(
        api: MarvelApiService,
        dao: FavoriteDao
    ): MarvelRepository =
        MarvelRepositoryImpl(api, dao)
}
