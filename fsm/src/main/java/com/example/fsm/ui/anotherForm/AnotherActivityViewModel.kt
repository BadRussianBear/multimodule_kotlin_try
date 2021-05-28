package com.example.fsm.ui.anotherForm

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

class AnotherActivityViewModel  @Inject
constructor (private val postDao: BaseDao, private val networkApi: ApiService): ViewModel(){
    val postListAdapter: AnotherListAdapter = AnotherListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()

    private lateinit var subscription: Disposable

    init{
        loadPosts()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadPosts(){
        longWork(
            { postDao.getGenders() },
            { onRetrievePostListStart()},
            { onRetrievePostListFinish()},
            {list -> onRetrievePostListSuccess(list)},
            { error -> onRetrievePostListError(error)});
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList:List<Any>){
        val list = postList.checkItemsAre<Gender>()
        if(list != null)
            postListAdapter.updatePostList(list)
    }

    fun callGetGenders(){
        longWork(
            { postDao.getGenders() },
            { onRetrievePostListStart()},
            { onRetrievePostListFinish()},
            {list -> onRetrievePostListSuccess(list)},
            { error -> onRetrievePostListError(error)});
//        postDao.getGenders();
//        myRepository.callMyRetrofitApi(liveData)
    }

    private fun onRetrievePostListError(error: Throwable){
        errorMessage.value = R.string.app_name
    }
}