package com.mendhie.movemate.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.transition.MaterialContainerTransform
import com.mendhie.movemate.R
import com.mendhie.movemate.data.models.SearchResult
import com.mendhie.movemate.databinding.FragmentSearchBinding
import com.mendhie.movemate.presentation.adapters.SearchAdapter
import com.mendhie.movemate.presentation.viewmodels.ShipmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private var defaultSearchResults = listOf<SearchResult>()
    private val viewModel: ShipmentViewModel by viewModels()
    private val adapter = SearchAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater)

        sharedElementEnterTransition = MaterialContainerTransform()

        //Set adapter and layoutManager for search recyclerView
        binding.lstSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.lstSearch.adapter = adapter
        binding.lstSearch.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager(requireContext()).orientation
            )
        )

        viewModel.defaultSearchResults.observe(viewLifecycleOwner){results->
            defaultSearchResults = results
            if(binding.edtSearch.text.toString().isEmpty()) {
                adapter.submitList(defaultSearchResults)
                binding.crdSearchResults.visibility = View.VISIBLE
            }
        }

        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
        observeSearchEditText()
        return binding.root
    }

    private fun observeSearchEditText() {
        binding.edtSearch.doOnTextChanged { _, _, _, _ ->
            val query = binding.edtSearch.text.toString().trim()
            val searchQuery = "%$query%"
            if(query.isEmpty()){
                adapter.submitList(defaultSearchResults)
                binding.crdSearchResults.visibility = View.VISIBLE
            }
            else{
                viewModel.getSearchResults(searchQuery).observe(viewLifecycleOwner){searchResults->
                    if(binding.edtSearch.text.toString().trim().isNotEmpty()){
                        adapter.submitList(searchResults)
                        binding.crdSearchResults.visibility = if(searchResults.isNotEmpty()) View.VISIBLE else View.GONE
                    }
                }
            }

        }
    }
}