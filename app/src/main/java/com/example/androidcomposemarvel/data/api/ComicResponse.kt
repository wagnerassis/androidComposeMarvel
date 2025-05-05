package com.example.androidcomposemarvel.data.api

import com.example.androidcomposemarvel.domain.models.Comic

data class ComicsResponse(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: ComicDataContainer
)

data class ComicDataContainer(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<ComicResponse>
)

data class ComicResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val thumbnail: ThumbnailResponse
)

data class ThumbnailResponse(
    val path: String,
    val extension: String
)

fun ComicResponse.toDomain(): Comic {
    val url = "${thumbnail.path}.${thumbnail.extension}"
    return Comic(
        id = id.toInt(),
        title = title,
        description = description,
        thumbnailUrl = url
    )
}
