package com.mendhie.movemate.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.mendhie.movemate.data.models.SearchResult
import com.mendhie.movemate.data.models.Shipment

@Dao
interface ShipmentDao {

    @Insert(onConflict = REPLACE)
    fun insertShipments(shipments: List<Shipment>)

    @Query("SELECT * FROM shipment_table")
    fun getShipments(): LiveData<List<Shipment>>

    @Insert(onConflict = REPLACE)
    fun insertSearchResults(results: List<SearchResult>)

    @Query("SELECT * FROM search_table WHERE trackingNumber LIKE :searchQuery")
    fun getSearchResults(searchQuery: String): LiveData<List<SearchResult>>

    @Query("SELECT * FROM search_table")
    fun getSearchResults(): LiveData<List<SearchResult>>
}