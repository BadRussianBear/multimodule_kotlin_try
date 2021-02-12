package com.example.one.di.component

import com.example.base.di.component.BaseComponent
import com.example.one.FeatureOneActivity
import com.example.one.di.module.FeatureOneModule
import com.example.one.di.scopes.FeatureOneScope
import dagger.Component

@FeatureOneScope
@Component(
    dependencies = [BaseComponent::class],
    modules = [FeatureOneModule::class]
)
interface FeatureOneComponent {

    fun inject(activity: FeatureOneActivity)

}