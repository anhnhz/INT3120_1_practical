package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {

    private val desserts: List<Dessert> = Datasource.dessertList

    private val _uiState = MutableStateFlow(
        DessertUiState(
            currentDessertImageId = desserts.first().imageId,
            currentDessertPrice = desserts.first().price
        )
    )
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun onDessertClicked() {
        val currentState = _uiState.value
        val newRevenue = currentState.revenue + currentState.currentDessertPrice
        val newSold = currentState.dessertsSold + 1

        val dessertToShow = determineDessertToShow(desserts, newSold)

        _uiState.update {
            it.copy(
                revenue = newRevenue,
                dessertsSold = newSold,
                currentDessertImageId = dessertToShow.imageId,
                currentDessertPrice = dessertToShow.price
            )
        }
    }

    private fun determineDessertToShow(desserts: List<Dessert>, dessertsSold: Int): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }
        return dessertToShow
    }
}
