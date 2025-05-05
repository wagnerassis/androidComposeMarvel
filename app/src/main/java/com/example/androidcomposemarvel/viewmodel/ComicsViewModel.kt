package com.example.androidcomposemarvel.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.androidcomposemarvel.domain.models.Comic
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.androidcomposemarvel.domain.repository.MarvelRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val repo: MarvelRepository
) : ViewModel() {
    val comicsFlow = repo.getComicsPager()
        .cachedIn(viewModelScope)

    val favoritesFlow = repo.getFavorites()

    fun onToggleFavorite(comic: Comic) = viewModelScope.launch {
        repo.toggleFavorite(comic)
    }
}
