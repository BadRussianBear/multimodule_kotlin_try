package com.example.two.di.component

import com.example.base.di.component.BaseComponent
import com.example.two.FeatureTwoActivity
import com.example.two.di.module.FeatureTwoModule
import com.example.two.di.scopes.FeatureTwoScope
import dagger.Component

@FeatureTwoScope
@Component(
    dependencies = [BaseComponent::class],
    modules = [FeatureTwoModule::class]
)
interface FeatureTwoComponent {

    fun inject(activity: FeatureTwoActivity)

}