package com.example.base.data.dao

import androidx.room.*
import com.example.base.data.model.Gender

@Dao
interface GenderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGender(gender: Gender)

    @Update
    fun updateGender(gender: Gender)

    @Delete
    fun deleteGender(gender: Gender)

    @Query("SELECT * FROM Gender WHERE name == :name")
    fun getGenderByName(name: String): List<Gender>?

    @Query("SELECT * FROM Gender")
    fun getGenders(): List<Gender>
}