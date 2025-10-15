package com.example.amphibians.model

import kotlinx.serialization.Serializable

@Serializable
data class BooksResponse(
    val items: List<BookItem>?
)
@Serializable
data class BookItem(
    val volumeInfo: VolumeInfo?
)
@Serializable
data class VolumeInfo(
    val imageLinks: ImageLinks?
)
@Serializable
data class ImageLinks(
    val thumbnail: String?
)
