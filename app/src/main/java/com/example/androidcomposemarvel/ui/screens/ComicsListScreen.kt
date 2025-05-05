package com.example.androidcomposemarvel.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidcomposemarvel.ui.components.ComicItem
import com.example.androidcomposemarvel.viewmodel.ComicsViewModel

@Composable
fun ComicsListScreen(vm: ComicsViewModel = hiltViewModel(), nav: NavController) {
    val pagingItems = vm.comicsFlow.collectAsLazyPagingItems()
    val favs by vm.favoritesFlow.collectAsState(initial = emptyList())
    val loadState = pagingItems.loadState

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Comics") },
                actions = {
                    IconButton(onClick = { nav.navigate("favs") }) {
                        Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorites")
                    }
                }
            )
        }
    ) { innerPadding ->
        LaunchedEffect(pagingItems.loadState) {
            Log.d("ComicsList", pagingItems.loadState.toString())
        }

        if (loadState.refresh is LoadState.Loading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                if (loadState.prepend is LoadState.Loading) {
                    item { CircularProgressIndicator(modifier = Modifier.fillMaxWidth()) }
                }

                items(
                    items = pagingItems.itemSnapshotList.items,
                    key = { it.id }
                ) { comic ->
                    ComicItem(
                        comic = comic,
                        isFav = favs.any { fav -> fav.id == comic.id },
                        onFavClick = { vm.onToggleFavorite(comic) }
                    )
                }

                if (loadState.append is LoadState.Loading) {
                    item { CircularProgressIndicator(modifier = Modifier.fillMaxWidth()) }
                }
            }
        }
    }
}
