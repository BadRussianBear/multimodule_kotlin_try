package com.example.base.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.base.data.dao.GenderDao
import com.example.base.data.model.Exercise
import com.example.base.data.model.Gender
import com.example.base.data.model.Routine
import com.example.base.utils.DateTypeConverter
import javax.inject.Singleton

@Singleton
@Database(entities = [Exercise::class, Gender::class, Routine::class], version = 130, exportSchema = false)
@TypeConverters(DateTypeConverter::class)
abstract class DataBase() : RoomDatabase() {
    abstract fun genderDao(): GenderDao

}