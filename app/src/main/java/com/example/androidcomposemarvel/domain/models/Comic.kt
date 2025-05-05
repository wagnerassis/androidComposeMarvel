package com.example.androidcomposemarvel.domain.models

import com.example.androidcomposemarvel.data.local.FavoriteComic

data class Comic(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnailUrl: String
)

fun Comic.toFavoriteComic(): FavoriteComic =
    FavoriteComic(
        id = id,
        title = title,
        description = description,
        thumbnailUrl = thumbnailUrl
    )