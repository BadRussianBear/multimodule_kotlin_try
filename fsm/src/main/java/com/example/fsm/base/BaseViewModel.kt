package com.example.fsm.base

import androidx.lifecycle.ViewModel
import com.example.fsm.DaggerViewModelInjector
import com.example.fsm.ViewModelInjector
import com.example.fsm.ui.anotherForm.AnotherViewModel
import com.example.fsm.ui.fsm.GenderViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is GenderViewModel -> injector.inject(this)
            is AnotherViewModel -> injector.inject(this)
        }
    }
}