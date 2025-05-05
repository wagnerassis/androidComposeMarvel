package com.example.androidcomposemarvel.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidcomposemarvel.domain.models.Comic

@Entity(tableName = "favorite_comics")
data class FavoriteComic(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String?,
    val thumbnailUrl: String
)

fun FavoriteComic.toComicDomain(): Comic =
    Comic(
        id = id,
        title = title,
        description = description,
        thumbnailUrl = thumbnailUrl
    )
