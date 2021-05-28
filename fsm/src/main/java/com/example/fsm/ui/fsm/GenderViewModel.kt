package com.example.fsm.ui.fsm

import androidx.lifecycle.MutableLiveData
import com.example.fsm.base.BaseViewModel
import com.example.shared.Gender

class GenderViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(gender: Gender){
        postTitle.value = gender.name
        postBody.value = gender.id?.toString()
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody():MutableLiveData<String>{
        return postBody
    }
}