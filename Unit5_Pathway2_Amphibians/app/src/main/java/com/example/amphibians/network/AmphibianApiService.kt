package com.example.amphibians.network

import com.example.amphibians.model.AmphibianPhoto
import retrofit2.http.GET

interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getPhotos(): List<AmphibianPhoto>
}