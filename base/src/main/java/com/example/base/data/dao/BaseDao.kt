package com.example.base.data.dao

import androidx.room.*
import com.example.base.data.model.GenderEntity
import com.example.shared.Gender

@Dao
interface BaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGender(gender: GenderEntity)

    @Update
    fun updateGender(gender: GenderEntity)

    @Delete
    fun deleteGender(gender: GenderEntity)

    @Query("SELECT * FROM GenderEntity WHERE name == :name")
    fun getGenderByName(name: String): List<GenderEntity>

    @Query("SELECT * FROM GenderEntity")
    fun getGenders(): List<GenderEntity>
}