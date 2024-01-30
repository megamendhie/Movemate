package com.mendhie.movemate.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mendhie.movemate.databinding.FragmentHistoryAllBinding
import com.mendhie.movemate.presentation.adapters.ShipmentAdapter
import com.mendhie.movemate.presentation.viewmodels.ShipmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryAllFragment(private val status: String = "") : Fragment() {
    private lateinit var binding: FragmentHistoryAllBinding
    private val viewModel: ShipmentViewModel by viewModels()
    private val adapter = ShipmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHistoryAllBinding.inflate(inflater)

        binding.lstHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.lstHistory.adapter = adapter

        viewModel.shipments.observe(viewLifecycleOwner) {shipments->
            if(status!=""){
                val list = shipments.filter { it.status == status }
                adapter.submitList(list)
            }
            else
                adapter.submitList(shipments)
        }
        return binding.root
    }
}