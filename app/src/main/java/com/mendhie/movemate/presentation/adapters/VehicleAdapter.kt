package com.mendhie.movemate.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mendhie.movemate.data.models.Vehicle
import com.mendhie.movemate.databinding.ItemVehicleBinding

class VehicleAdapter(private val vehicles: List<Vehicle>): Adapter<VehicleAdapter.VehicleViewHolder>() {

    inner class VehicleViewHolder(private val binding: ItemVehicleBinding): ViewHolder(binding.root){

        fun bindView(vehicle: Vehicle){
            binding.apply {
                txtVehicleType.text = vehicle.vehicleType
                txtRegion.text = vehicle.region
                imgVehicle.setImageResource(vehicle.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val binding = ItemVehicleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VehicleViewHolder(binding)
    }

    override fun getItemCount(): Int = vehicles.size

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.bindView(vehicles[position])
    }
}