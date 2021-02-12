package com.example.fsm.main.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fsm.ViewModelFactory
import com.example.fsm.ui.anotherForm.AnotherActivityViewModel
import com.example.fsm.ui.fsm.FsmActivityViewModel
import com.example.fsm.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FsmActivityViewModel::class)
    internal abstract fun bindProdListFragmentViewModel(fsmActivityViewModel: FsmActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AnotherActivityViewModel::class)
    internal abstract fun bindDetailActivityViewModel(anotherActivityViewModel: AnotherActivityViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}