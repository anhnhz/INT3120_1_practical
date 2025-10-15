package com.example.amphibians.network

import com.example.amphibians.model.AmphibianPhoto
import retrofit2.http.GET

interface AmphibianApiService {
    @GET("volumes?q=jazz+history")
    suspend fun getPhotos(): List<AmphibianPhoto>
}