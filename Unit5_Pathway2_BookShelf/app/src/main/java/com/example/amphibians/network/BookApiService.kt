package com.example.amphibians.network

import com.example.amphibians.model.BooksResponse
import retrofit2.http.GET

interface BooksApiService {
    @GET("books/v1/volumes?q=jazz+history")
    suspend fun getBooks(): BooksResponse
}