package com.example.base.data.dao

import com.example.base.data.model.Gender

interface GenderRepository {
    fun getGenderByName(name: String): List<Gender>?
    fun getGenders(): List<Gender>
    fun insert(gender: Gender)
    fun delete(gender: Gender)
}