package com.mendhie.movemate.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mendhie.movemate.R
import com.mendhie.movemate.data.models.Shipment
import com.mendhie.movemate.databinding.ItemShipmentBinding
import com.mendhie.movemate.presentation.utils.Utils

class ShipmentAdapter : ListAdapter<Shipment, ShipmentAdapter.ShipmentViewHolder>(Utils.ShipmentDiffUtilCallback){

    inner class ShipmentViewHolder(private val binding: ItemShipmentBinding): ViewHolder(binding.root){

        fun bindView(shipment: Shipment){
            binding.apply {
                when(shipment.status){
                    "in-progress" -> txtStatus.setTextColor(binding.root.context.resources.getColor(
                        R.color.shipment_in_progress))
                    "pending" -> txtStatus.setTextColor(binding.root.context.resources.getColor(
                        R.color.shipment_pending))
                    "loading" ->  txtStatus.setTextColor(binding.root.context.resources.getColor(
                        R.color.shipment_loading))
                    "cancelled" ->  txtStatus.setTextColor(binding.root.context.resources.getColor(
                        R.color.shipment_cancelled))
                }
                txtStatus.text = shipment.status
                txtAmount.text = shipment.amount
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipmentViewHolder {
        val binding = ItemShipmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShipmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShipmentViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }
}