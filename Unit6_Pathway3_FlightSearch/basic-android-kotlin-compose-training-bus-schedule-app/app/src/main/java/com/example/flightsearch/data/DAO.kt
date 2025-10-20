package com.example.flightsearch.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {
    @Query("SELECT * FROM airport ORDER BY name ASC")
    fun getAllAirports(): Flow<List<AirportEntity>>

    @Query("SELECT * FROM airport WHERE name LIKE :query OR iata_code LIKE :query ORDER BY name ASC")
    fun searchAirports(query: String): Flow<List<AirportEntity>>
}
