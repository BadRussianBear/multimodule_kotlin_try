package com.example.fsm

import com.example.fsm.ui.anotherForm.AnotherViewModel
import com.example.fsm.ui.fsm.FsmActivityViewModel
import com.example.fsm.ui.fsm.GenderViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [])
interface ViewModelInjector {
    fun inject(postViewModel: GenderViewModel)
    fun inject(anotherViewModel: AnotherViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
    }
}