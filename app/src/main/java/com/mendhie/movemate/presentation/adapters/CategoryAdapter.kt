package com.mendhie.movemate.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mendhie.movemate.R
import com.mendhie.movemate.databinding.ItemCategoryBinding

class CategoryAdapter(private val categories: List<String>): Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var selectedBinding: ItemCategoryBinding? = null
    private var selectedCategory = ""

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding): ViewHolder(binding.root){

        fun bindView(category: String){
            if(selectedCategory == category){
                binding.root.setBackgroundResource(R.drawable.bg_highlighted_selected)
                binding.txtCategory.setTextColor(binding.root.context.resources.getColor(R.color.white))
                selectedBinding = binding
            }
            else{
                binding.root.setBackgroundResource(R.drawable.bg_highlighted_unselected)
                binding.txtCategory.setTextColor(binding.root.context.resources.getColor(R.color.header_text_color))
            }
            binding.txtCategory.text = category

            binding.root.setOnClickListener {
                if(binding!=selectedBinding){
                    selectedBinding?.root?.setBackgroundResource(R.drawable.bg_highlighted_unselected)
                    selectedBinding?.txtCategory?.setTextColor(binding.root.context.resources.getColor(R.color.header_text_color))

                    binding.root.setBackgroundResource(R.drawable.bg_highlighted_selected)
                    binding.txtCategory.setTextColor(binding.root.context.resources.getColor(R.color.white))
                    selectedBinding = binding
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int  = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindView(categories[position])
    }
}