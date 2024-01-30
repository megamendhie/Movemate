package com.mendhie.movemate.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.transition.Hold
import com.mendhie.movemate.R
import com.mendhie.movemate.data.models.Vehicle
import com.mendhie.movemate.databinding.FragmentHomeBinding
import com.mendhie.movemate.presentation.adapters.VehicleAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)

        binding.txtSearch.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.cnsHeader to "alex")
            findNavController().navigate(R.id.action_navHome_to_search, null, null, extras)
        }

        val vehicles = listOf(
            Vehicle("Ocean freight", "International", R.drawable.pic_ship),
            Vehicle("Cargo freight", "Reliable", R.drawable.pic_truck),
            Vehicle("Air freight", "International", R.drawable.pic_air_plane)
        )
        binding.lstVehicle.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.lstVehicle.adapter = VehicleAdapter(vehicles)

        exitTransition = Hold()
        return binding.root
    }
}