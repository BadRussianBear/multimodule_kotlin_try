package com.example.fsm.main.di.component

import android.app.Application
import com.example.fsm.FsmApplication
import com.example.fsm.main.di.module.ActivityBindingModule
import com.example.fsm.main.di.module.ViewModelModule
import com.example.base.di.module.RoomModule
import com.example.network.data.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(RoomModule::class), (NetworkModule::class), (AndroidSupportInjectionModule::class), (ViewModelModule::class), (ActivityBindingModule::class)])
interface FsmApplicationComponent : AndroidInjector<DaggerApplication> {
    fun inject(application: FsmApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): FsmApplicationComponent
    }
}