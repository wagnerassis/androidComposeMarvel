package com.example.androidcomposemarvel.viewmodel

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import androidx.paging.PagingData
import com.example.androidcomposemarvel.data.local.FavoriteComic
import org.junit.Test
import com.example.androidcomposemarvel.domain.models.Comic
import com.example.androidcomposemarvel.domain.repository.MarvelRepository

@ExperimentalCoroutinesApi
class ComicsViewModelTest {

    private class FakeMarvelRepository(
        private val comics: List<Comic>
    ) : MarvelRepository {
        suspend fun fetchComics(): List<Comic> = comics

        // implement the new pager API
        override fun getComicsPager(): Flow<PagingData<Comic>> =
            flowOf(PagingData.from(comics))

        override fun getFavorites(): Flow<List<FavoriteComic>> {
            return flowOf(emptyList())
        }

        override suspend fun toggleFavorite(comic: Comic) {

        }
    }

    @Test
    fun loadComics_success_setsUiState() = runBlockingTest {
        val sample = listOf(Comic(
            id = 1, title = "Teste",
            description = "",
            thumbnailUrl = ""
        ))
        val repo = FakeMarvelRepository(sample)
        val vm = ComicsViewModel(repo)
    }
}
