package com.example.module

import com.example.module.main.di.component.DaggerMainApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication  : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out MyApplication>? {
        val component = DaggerMainApplicationComponent.builder().application(this).build()
        component.inject(this)
        return component
    }


}