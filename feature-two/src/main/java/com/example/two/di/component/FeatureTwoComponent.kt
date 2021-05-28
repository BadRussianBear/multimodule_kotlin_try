package com.example.two.di.component

import com.example.base.di.component.DBaseComponent
import com.example.two.FeatureTwoActivity
import com.example.two.di.module.FeatureTwoModule
import com.example.two.di.scopes.FeatureTwoScope
import dagger.Component

@FeatureTwoScope
@Component(
    dependencies = [DBaseComponent::class],
    modules = [FeatureTwoModule::class]
)
interface FeatureTwoComponent {

    fun inject(activity: FeatureTwoActivity)

}