package com.example.amphibians.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibianPhotoApplication
import com.example.amphibians.data.NetworkBooksRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface BooksUiState {
    data class Success(val thumbnails: List<String>) : BooksUiState
    object Error : BooksUiState
    object Loading : BooksUiState
}


class BooksViewModel(private val booksRepository: NetworkBooksRepository) : ViewModel() {

    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        getBookThumbnails()
    }

    fun getBookThumbnails() {
        viewModelScope.launch {
            booksUiState = BooksUiState.Loading
            booksUiState = try {
                val thumbnails = booksRepository.getThumbnails()
                BooksUiState.Success(thumbnails)
            } catch (e: IOException) {
                BooksUiState.Error
            } catch (e: HttpException) {
                BooksUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianPhotoApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }
}
