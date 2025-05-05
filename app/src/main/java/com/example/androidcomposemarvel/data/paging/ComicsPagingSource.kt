package com.example.androidcomposemarvel.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.androidcomposemarvel.data.api.ComicResponse
import com.example.androidcomposemarvel.domain.models.Comic
import com.example.androidcomposemarvel.data.api.MarvelApiService
import com.example.androidcomposemarvel.data.api.toDomain

class ComicsPagingSource(
    private val api: MarvelApiService
) : PagingSource<Int, Comic>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comic> {
        val page = params.key ?: 0
        return try {
            val resp = api.getComics(limit = 15, offset = page)
            val list = resp.data.results.map { it.toDomain() }

            LoadResult.Page(
                data = list,
                prevKey = if (page == 0) null else page - 15,
                nextKey = if (list.isEmpty()) null else page + 15
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Comic>) = null
}
