package com.example.fsm.ui.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.fsm.databinding.AnotherGenderBinding
import com.example.fsm.ui.anotherForm.AnotherViewModel
import com.example.shared.Gender

class AnotherViewHolder(private val binding: AnotherGenderBinding): RecyclerView.ViewHolder(binding.root){
    private val viewModel = AnotherViewModel()
    fun bind(post: Gender){
        viewModel.bind(post)
        binding.viewModel = viewModel
    }
}