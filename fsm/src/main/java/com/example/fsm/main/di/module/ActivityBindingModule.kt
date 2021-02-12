package com.example.fsm.main.di.module

import com.example.fsm.ui.anotherForm.AnotherActivity
import com.example.fsm.ui.fsm.FsmActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    internal abstract fun contributeFsmActivity(): FsmActivity

    @ContributesAndroidInjector
    internal abstract fun contributeAnotherActivity(): AnotherActivity
}