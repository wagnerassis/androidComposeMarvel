package com.example.androidcomposemarvel.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.androidcomposemarvel.data.api.MarvelApiService
import com.example.androidcomposemarvel.data.local.FavoriteComic
import com.example.androidcomposemarvel.data.local.FavoriteDao
import com.example.androidcomposemarvel.data.paging.ComicsPagingSource
import com.example.androidcomposemarvel.domain.models.Comic
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val api: MarvelApiService,
    private val dao: FavoriteDao
) : MarvelRepository {
    override fun getComicsPager() =
        Pager(PagingConfig(pageSize = 15)) {
            ComicsPagingSource(api)
        }.flow

    override fun getFavorites() = dao.getAll()

    override suspend fun toggleFavorite(comic: Comic) {
        val fav = FavoriteComic(comic.id, comic.title, description = comic.description, comic.thumbnailUrl)
        val exists = dao.getAll().first().any { it.id == comic.id }
        if (exists) dao.delete(fav) else dao.insert(fav)
    }
}
