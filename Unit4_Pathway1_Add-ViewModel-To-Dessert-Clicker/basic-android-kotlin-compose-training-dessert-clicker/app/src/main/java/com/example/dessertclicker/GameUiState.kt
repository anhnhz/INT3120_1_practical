package com.example.dessertclicker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.annotation.DrawableRes

data class DessertUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    @DrawableRes val currentDessertImageId: Int = 0,
    val currentDessertPrice: Int = 0
)
