package com.example.androidcomposemarvel.data.api.models

import com.example.androidcomposemarvel.domain.models.Comic

data class ComicDto(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnail: ThumbnailDto
)

data class ThumbnailDto(
    val path: String,
    val extension: String
)

fun ComicDto.toDomain(): Comic {
    return Comic(
        id = this.id,
        title = this.title,
        description = this.description ?: "",
        thumbnailUrl = "${this.thumbnail.path}.${this.thumbnail.extension}"
    )
}