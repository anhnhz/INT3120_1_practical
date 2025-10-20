package com.example.flightsearch

import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.runtime.Composable
import com.example.flightsearch.data.FlightSearchDatabase
import com.example.flightsearch.ui.FlightSearchViewModel
import com.example.flightsearch.ui.FlightSearchViewModelFactory
import com.example.flightsearch.ui.screens.SearchScreen
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FlightSearchApp(context: Context) {
    val database = FlightSearchDatabase.getDatabase(context)
    val dao = database.flightDao()
    val viewModel: FlightSearchViewModel = viewModel(
        factory = FlightSearchViewModelFactory(dao)
    )

    val airports by viewModel.airports.collectAsState(initial = emptyList())
    val query by viewModel.query.collectAsState()

    SearchScreen(
        airports = airports,
        query = query,
        onQueryChange = viewModel::updateQuery
    )
}
