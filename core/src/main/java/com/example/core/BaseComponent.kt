package com.example.core

import android.app.Application
import android.content.SharedPreferences
import com.example.base.di.component.DBaseComponent
import com.example.base.di.module.RoomModule
import com.example.network.data.NetworkComponent
import com.example.network.data.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoreModule::class,
        RoomModule::class,
        NetworkModule::class
    ]
)
interface BaseComponent : DBaseComponent, NetworkComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): BaseComponent
    }

    fun application(): Application

    fun sharedPreferences(): SharedPreferences
}