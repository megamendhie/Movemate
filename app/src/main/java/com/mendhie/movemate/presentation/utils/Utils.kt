package com.mendhie.movemate.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.mendhie.movemate.data.models.SearchResult
import com.mendhie.movemate.data.models.Shipment

object Utils {
    object ShipmentDiffUtilCallback : DiffUtil.ItemCallback<Shipment>() {
        override fun areItemsTheSame(oldItem: Shipment, newItem: Shipment): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Shipment, newItem: Shipment): Boolean {
            return oldItem.trackingNumber == newItem.trackingNumber
        }

    }


    object SearchDiffUtilCallback : DiffUtil.ItemCallback<SearchResult>() {
        override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
            return oldItem.trackingNumber == newItem.trackingNumber
        }

    }
}