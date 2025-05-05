package com.example.androidcomposemarvel.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.IconButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import com.example.androidcomposemarvel.data.local.toComicDomain
import com.example.androidcomposemarvel.ui.components.ComicItem
import com.example.androidcomposemarvel.viewmodel.ComicsViewModel

@Composable
fun FavoritesScreen(
    navController: NavHostController,
    vm: ComicsViewModel = hiltViewModel()
) {
    val favs by vm.favoritesFlow.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { "Favoritos"},
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(
                items = favs,
                key = { it.id }
            ) { fav ->
                ComicItem(
                    fav.toComicDomain(),
                    isFav = true,
                    onFavClick = {
                        vm.onToggleFavorite(fav.toComicDomain())
                    }
                )
            }
        }
    }
}
