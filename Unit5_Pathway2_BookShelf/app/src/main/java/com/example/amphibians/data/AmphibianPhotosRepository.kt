package com.example.amphibians.data

import com.example.amphibians.model.AmphibianPhoto
import com.example.amphibians.network.AmphibianApiService
import com.example.amphibians.network.BooksApiService

interface AmphibianPhotosRepository {
    suspend fun getAmphibianPhotos(): List<AmphibianPhoto>
}

class NetworkAmphibianPhotosRepository(
    private val amphibianApiService: AmphibianApiService
) : AmphibianPhotosRepository {
    /** Fetches list of MarsPhoto from marsApi*/
    override suspend fun getAmphibianPhotos(): List<AmphibianPhoto> {
        return amphibianApiService.getPhotos()
    }
}

class NetworkBooksRepository(private val api: BooksApiService) {

    suspend fun getThumbnails(): List<String> {
        val response = api.getBooks()
        return response.items
            ?.mapNotNull { it.volumeInfo?.imageLinks?.thumbnail }
            ?: emptyList()
    }
}

