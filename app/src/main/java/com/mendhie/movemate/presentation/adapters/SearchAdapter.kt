package com.mendhie.movemate.presentation.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mendhie.movemate.data.models.SearchResult
import com.mendhie.movemate.databinding.ItemSearchBinding
import com.mendhie.movemate.presentation.utils.Utils

class SearchAdapter: ListAdapter<SearchResult, SearchAdapter.SearchViewHolder>(Utils.SearchDiffUtilCallback){


    inner class SearchViewHolder(val binding: ItemSearchBinding): ViewHolder(binding.root){

        fun bindView(searchResult: SearchResult){
            binding.apply {
                txtProduct.text = searchResult.product
                txtShipmentNumber.text = searchResult.trackingNumber
                txtSenderAddress.text = searchResult.senderAddress
                txtReceiverAddress.text = searchResult.receiverAddress
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }
}