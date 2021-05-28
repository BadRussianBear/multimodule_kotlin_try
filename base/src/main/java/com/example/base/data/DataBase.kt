package com.example.base.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.base.data.dao.BaseDao
import com.example.base.data.model.Exercise
import com.example.base.data.model.GenderEntity
import com.example.base.data.model.Routine
import com.example.base.utils.DateTypeConverter
import javax.inject.Singleton

@Singleton
@Database(entities = [Exercise::class, GenderEntity::class, Routine::class], version = 130, exportSchema = false)
@TypeConverters(DateTypeConverter::class)
abstract class DataBase() : RoomDatabase() {
    abstract fun genderDao(): BaseDao
}