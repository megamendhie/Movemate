package com.mendhie.movemate.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.mendhie.movemate.R
import com.mendhie.movemate.databinding.FragmentCalculateBinding
import com.mendhie.movemate.presentation.adapters.CategoryAdapter


class CalculateFragment : Fragment() {
    private lateinit var binding: FragmentCalculateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCalculateBinding.inflate(inflater)
        binding.toolbar.apply {
            //set default toolbar title and navigationIcon click
            setNavigationOnClickListener{findNavController().navigateUp()}
        }

        binding.lstCategories.apply {
            setHasFixedSize(true)
            val layoutManagerFlex = FlexboxLayoutManager(context)
            layoutManagerFlex.flexDirection = FlexDirection.ROW
            layoutManager = layoutManagerFlex
            adapter = CategoryAdapter(listOf("Documents", "Glass", "Liquid", "Food", "Electronic", "Product", "Others"))
        }

        binding.btnCalculate.setOnClickListener {
            findNavController().navigate(R.id.action_navCalculate_to_calculator)
        }
        return binding.root
    }



}