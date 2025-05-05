package com.example.androidcomposemarvel.domain.repository

import androidx.paging.PagingData
import com.example.androidcomposemarvel.data.local.FavoriteComic
import com.example.androidcomposemarvel.domain.models.Comic
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getComicsPager(): Flow<PagingData<Comic>>
    fun getFavorites(): Flow<List<FavoriteComic>>
    suspend fun toggleFavorite(comic: Comic)
}
