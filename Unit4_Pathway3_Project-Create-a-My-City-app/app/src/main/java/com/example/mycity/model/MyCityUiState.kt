package com.example.mycity.model

import com.example.mycity.data.DataResources
import com.example.mycity.ui.Category
import com.example.mycity.model.Location

data class MyCityUiState (
    val chosenCategory: Category = Category.CoffeeShops,
    val chosenLocation: Location = DataResources.getCafeList()[0]
)