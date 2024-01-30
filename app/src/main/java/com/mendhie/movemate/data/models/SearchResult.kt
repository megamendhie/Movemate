package com.mendhie.movemate.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_table")
data class SearchResult(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val product: String,
    val trackingNumber: String,
    val senderAddress: String,
    val receiverAddress: String
)
