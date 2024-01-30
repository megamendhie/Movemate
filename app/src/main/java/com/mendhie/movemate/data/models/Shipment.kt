package com.mendhie.movemate.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shipment_table")
data class Shipment(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val status: String,
    val arrivalTime: String,
    val amount: String,
    val trackingNumber: String,
    val date: String
)
