package com.example.mycity.ui


import androidx.lifecycle.ViewModel
import com.example.mycity.model.Location
import com.example.mycity.model.MyCityUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun updateChosenCategory(category: Category) {
        _uiState.update {
            it.copy(
                chosenCategory = category
            )
        }
    }
    fun updateChosenLocation(location: Location) {
        _uiState.update {
            it.copy(
                chosenLocation = location
            )
        }
    }

}
