package com.example.base.di.module

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import androidx.room.migration.Migration
import com.example.base.data.DataBase
import com.example.base.data.dao.GenderDao
import com.example.base.data.dao.GenderDataSource
import com.example.base.utils.MIGRATION_130_2
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
open class RoomModule() {
//    private val demoDatabase: DataBase

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): DataBase {
        return Room.databaseBuilder(
            application.applicationContext,
            DataBase::class.java,
            "ic_forms_data.db")
            .addMigrations(getMigrations())
            .build()
    }

    private fun getMigrations() : Migration {
        return MIGRATION_130_2
    }

    @Singleton
    @Provides
    fun provideGenderDao(database: DataBase): GenderDao {
        return database.genderDao()
    }

    @Singleton
    @Provides
    fun provideGenderDataSource(genderDao: GenderDao): GenderDataSource {
        return GenderDataSource(genderDao)
    }
//    init {
//        demoDatabase =
//            Room.databaseBuilder<DataBase>(mApplication!!, DataBase::class.java, "demo-db")
//                .build()
//    }
}