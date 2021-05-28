package com.example.base.di.component

import android.app.Application
import com.example.base.di.module.RoomModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomModule::class])
interface DBaseComponent {

    fun inject(app: Application)
}