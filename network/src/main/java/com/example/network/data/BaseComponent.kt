package com.example.network.data

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface BaseComponent {
    fun inject(app: Application)
}