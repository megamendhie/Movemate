package com.mendhie.movemate.presentation.adapters

import android.R.attr.button
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mendhie.movemate.R
import com.mendhie.movemate.data.models.Shipment
import com.mendhie.movemate.databinding.ItemShipmentBinding
import com.mendhie.movemate.presentation.utils.Utils


class ShipmentAdapter : ListAdapter<Shipment, ShipmentAdapter.ShipmentViewHolder>(Utils.ShipmentDiffUtilCallback){

    inner class ShipmentViewHolder(private val binding: ItemShipmentBinding): ViewHolder(binding.root){

        fun bindView(shipment: Shipment){
            var img: Drawable = binding.root.context.resources.getDrawable(R.drawable.ic_check_circle_24px)

            binding.apply {
                when(shipment.status){
                    "in-progress" -> {
                        txtStatus.setTextColor(
                            binding.root.context.resources.getColor(
                                R.color.shipment_in_progress
                            )
                        )
                        img = binding.root.context.resources.getDrawable(R.drawable.ic_cached_24px)
                    }
                    "pending" -> {
                        txtStatus.setTextColor(
                            binding.root.context.resources.getColor(
                                R.color.shipment_pending
                            )
                        )
                        img = binding.root.context.resources.getDrawable(R.drawable.ic_history_sec_24px)
                    }
                    "loading" -> {
                        txtStatus.setTextColor(
                            binding.root.context.resources.getColor(
                                R.color.shipment_loading
                            )
                        )
                        img = binding.root.context.resources.getDrawable(R.drawable.ic_rotate_right_24px)
                    }
                    "cancelled" ->  txtStatus.setTextColor(binding.root.context.resources.getColor(
                        R.color.shipment_cancelled))
                }
                txtStatus.text = shipment.status
                txtAmount.text = shipment.amount
                binding.txtStatus.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
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