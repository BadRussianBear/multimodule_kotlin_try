package com.example.fsm;

import com.example.fsm.main.di.component.DaggerFsmApplicationComponent
import com.example.fsm.main.di.component.FsmApplicationComponent
import dagger.android.DaggerApplication

class FsmApplication : DaggerApplication() {
    override fun applicationInjector(): FsmApplicationComponent {

        val component = DaggerFsmApplicationComponent.builder().application(this).build()
        component.inject(this)
        return component
    }


}