package com.example.fsm.ui.fsm

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fsm.R
import com.example.fsm.utils.checkItemsAre
import com.example.base.data.dao.BaseDao
import io.reactivex.disposables.Disposable
import com.example.fsm.utils.longWork
import com.example.network.data.ApiService
import com.example.shared.Gender
import javax.inject.Inject

class FsmActivityViewModel  @Inject
constructor(private val postDao: BaseDao, private val networkApi: ApiService): ViewModel(){

    val postListAdapter: GenderListAdapter = GenderListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()

    private lateinit var subscription: Disposable

//    init{
//        callGetGenders()
//    }

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

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList:List<Any>){
        val list = postList.checkItemsAre<Gender>()
        if(!list.isNullOrEmpty()){
            postListAdapter.updatePostList(list)
        }

//        if (postList.all { it is Gender } ){
//            val a: List<Gender> = postList.filterIsInstance<Gender>()
//            postListAdapter.updatePostList(postList.filterIsInstance<Gender>())
//        }
    }

    private fun onRetrievePostListError(error: Throwable){
        errorMessage.value = R.string.app_name
    }

    fun callGetGenders(){
        longWork(
            { networkApi.getUser() },
            { onRetrievePostListStart()},
            { onRetrievePostListFinish()},
            {list -> onRetrievePostListSuccess(list)},
            { error -> onRetrievePostListError(error)});

    }
}