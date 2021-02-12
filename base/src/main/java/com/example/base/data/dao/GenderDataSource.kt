package com.example.base.data.dao

import com.example.base.data.model.Gender
import javax.inject.Inject


class GenderDataSource @Inject constructor(private val genderDao: GenderDao) : GenderRepository {

    override fun getGenderByName(name: String): List<Gender>? {
        return genderDao.getGenderByName(name)
    }

    override fun getGenders(): List<Gender> {
        return genderDao.getGenders()
    }

    override  fun insert(gender: Gender) {
        return genderDao.insertGender(gender)
    }

    override fun delete(gender: Gender) {
        return genderDao.deleteGender(gender)
    }

}