package com.example.amphibians.data

import com.example.amphibians.model.AmphibianPhoto
import com.example.amphibians.network.AmphibianApiService

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