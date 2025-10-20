package com.example.flightsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.flightsearch.data.AirportEntity
import com.example.flightsearch.data.FlightDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FlightSearchViewModel(private val dao: FlightDao) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val _airports = MutableStateFlow<List<AirportEntity>>(emptyList())
    val airports: StateFlow<List<AirportEntity>> = _airports

    init {
        viewModelScope.launch {
            dao.getAllAirports().collect { list ->
                _airports.value = list
            }
        }
    }

    fun updateQuery(newQuery: String) {
        _query.value = newQuery
        viewModelScope.launch {
            dao.searchAirports("%${newQuery}%").collect { list ->
                _airports.value = list
            }
        }
    }
}


class FlightSearchViewModelFactory(
    private val dao: FlightDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlightSearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FlightSearchViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}