package com.example.fsm.ui.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.fsm.databinding.ItemGenderBinding
import com.example.fsm.ui.fsm.GenderViewModel
import com.example.shared.Gender

class GenderViewHolder(private val binding: ItemGenderBinding): RecyclerView.ViewHolder(binding.root){
    private val viewModel = GenderViewModel()
    fun bind(post: Gender){
        viewModel.bind(post)
        binding.viewModel = viewModel
    }
}