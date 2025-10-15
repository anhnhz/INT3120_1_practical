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
import com.example.amphibians.data.AmphibianPhotosRepository
import com.example.amphibians.data.NetworkAmphibianPhotosRepository
import com.example.amphibians.model.AmphibianPhoto
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AmphibiansUiState {
    data class Success(val photos: List<AmphibianPhoto>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}

class AmphibiansViewModel(private val amphibianPhotosRepository: AmphibianPhotosRepository) : ViewModel() {
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibianPhotosRepository.getAmphibianPhotos())
            } catch (e: IOException) {
                AmphibiansUiState.Error
            } catch (e: HttpException) {
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianPhotoApplication)
                val amphibianPhotosRepository = application.container.amphibianPhotosRepository
                AmphibiansViewModel(amphibianPhotosRepository = amphibianPhotosRepository)
            }
        }
    }
}