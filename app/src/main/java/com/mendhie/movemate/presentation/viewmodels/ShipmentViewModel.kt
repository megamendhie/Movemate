package com.mendhie.movemate.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mendhie.movemate.data.database.ShipmentDao
import com.mendhie.movemate.data.models.SearchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShipmentViewModel @Inject constructor(private val dao: ShipmentDao): ViewModel() {

    val shipments = dao.getShipments()

    val defaultSearchResults = dao.getSearchResults()

    fun getSearchResults(searchQuery: String): LiveData<List<SearchResult>>{
        return dao.getSearchResults(searchQuery)
    }
}