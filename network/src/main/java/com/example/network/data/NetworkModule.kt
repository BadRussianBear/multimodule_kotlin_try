package com.example.network.data

import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun apiService() : ApiService {
        return ApiService()
    }
}