package com.example.base.data.dao

import com.example.base.data.model.GenderEntity
import com.example.shared.Gender


interface BaseRepository {
    fun getGenderByName(name: String): List<Gender>?
    fun getGenders(): List<Gender>
    fun insert(gender: Gender)
    fun delete(gender: Gender)
}