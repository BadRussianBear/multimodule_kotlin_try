package com.example.one

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.dagger.multi.module.feature.one.R

class FeatureOneActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_one)
    }
}
