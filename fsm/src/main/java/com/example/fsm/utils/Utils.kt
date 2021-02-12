package com.example.fsm.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
fun longWork(
        caller :() -> List<Any>,
        onRetrievePostListStart: () -> Unit,
        onRetrievePostListFinish: () -> Unit,
        onRetrievePostListSuccess: (result: List<Any>) -> Unit,
        onRetrievePostListError: (error: Throwable) -> Unit
) {
    Observable.fromCallable { caller() }
    .concatMap {
            dbPostList ->
            Thread.sleep(10000)
            Observable.just(dbPostList)
    }
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .doOnSubscribe { onRetrievePostListStart() }
    .doOnTerminate { onRetrievePostListFinish() }
    .subscribe(
        { result -> onRetrievePostListSuccess(result) },
        { error -> onRetrievePostListError(error) }
    )
}


fun Context.toast(message: String){
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Any> List<*>.checkItemsAre() =
    if (all { it is T })
        this as List<T>
    else null