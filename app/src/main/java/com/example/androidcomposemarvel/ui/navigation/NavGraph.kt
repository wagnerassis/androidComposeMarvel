package com.example.androidcomposemarvel.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidcomposemarvel.ui.screens.ComicsListScreen
import com.example.androidcomposemarvel.ui.screens.FavoritesScreen


@Composable
fun NavGraph() {
    val nav = rememberNavController()
    NavHost(nav, startDestination = "list") {
        composable("list") { ComicsListScreen(nav = nav) }
        composable("favs") { FavoritesScreen(navController = nav) }
    }
}
