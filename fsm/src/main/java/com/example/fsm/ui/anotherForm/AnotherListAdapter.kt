package com.example.fsm.ui.anotherForm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fsm.R
import com.example.fsm.databinding.AnotherGenderBinding
import com.example.base.data.model.Gender
import com.example.fsm.ui.viewHolders.AnotherViewHolder

class AnotherListAdapter() : RecyclerView.Adapter<AnotherViewHolder>() {
    private lateinit var postList:List<Gender>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnotherViewHolder {
        val binding: AnotherGenderBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.another_gender, parent, false)
        return AnotherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnotherViewHolder, position: Int) {
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