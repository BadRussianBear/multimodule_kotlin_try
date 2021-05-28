package com.example.module.main.di.component

import com.example.module.MyApplication
import com.example.module.main.di.module.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(MainActivityModule::class), (AndroidSupportInjectionModule::class)])
interface MainApplicationComponent : AndroidInjector<MyApplication> {
    override fun inject(application: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        fun build(): MainApplicationComponent
    }
}