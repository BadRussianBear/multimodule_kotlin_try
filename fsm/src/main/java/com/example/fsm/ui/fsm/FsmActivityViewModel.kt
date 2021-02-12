package com.example.fsm.ui.fsm

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fsm.R
import com.example.fsm.base.BaseViewModel
import com.example.fsm.utils.checkItemsAre
import com.example.base.data.dao.GenderDao
import com.example.base.data.model.Gender
import io.reactivex.disposables.Disposable
import com.example.fsm.utils.longWork
import javax.inject.Inject

class FsmActivityViewModel  @Inject
constructor(private val postDao: GenderDao): ViewModel(){

    val postListAdapter: GenderListAdapter = GenderListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()

    private lateinit var subscription: Disposable

    init{
        loadPosts()
    }

    override fun onCleared() {
        super.onCleared()
//        subscription.dispose()
    }

    private fun loadPosts(){
        longWork(
            { postDao.getGenders() },
            { onRetrievePostListStart()},
            { onRetrievePostListFinish()},
            {list -> onRetrievePostListSuccess(list)},
            { error -> onRetrievePostListError(error)});
    }

    fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    fun onRetrievePostListSuccess(postList:List<Any>){
        val list = postList.checkItemsAre<Gender>()
        if(list != null)
            postListAdapter.updatePostList(list)
    }

    private fun onRetrievePostListError(error: Throwable){
        errorMessage.value = R.string.app_name
    }
}