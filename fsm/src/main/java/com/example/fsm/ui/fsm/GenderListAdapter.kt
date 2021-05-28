package com.example.fsm.ui.fsm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fsm.R
import com.example.fsm.databinding.ItemGenderBinding
import com.example.fsm.ui.viewHolders.GenderViewHolder
import com.example.shared.Gender

class GenderListAdapter() : RecyclerView.Adapter<GenderViewHolder>() {
    private lateinit var postList:List<Gender>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenderViewHolder {
        val binding: ItemGenderBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_gender, parent, false)
        return GenderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenderViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0
    }

    fun updatePostList(postList:List<Gender>){
        this.postList = postList
        notifyDataSetChanged()
    }

}