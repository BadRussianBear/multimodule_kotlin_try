package com.example.base.data.dao

import com.example.base.data.model.GenderEntity
import com.example.shared.Gender
import javax.inject.Inject


class BaseDataSource @Inject constructor(private val baseDao: BaseDao) : BaseRepository {

    override fun getGenderByName(name: String): List<Gender> {
        val genders: List<GenderEntity> = baseDao.getGenderByName(name);
        val result: List<Gender> = genders
            .groupBy { it.id }
            .map { Gender(it.key, it.value.first().name) };

        return result;
    }

    override fun getGenders(): List<Gender> {
        val genders: List<GenderEntity> = baseDao.getGenders();
        val result: List<Gender> = genders
            .groupBy { it.id }
            .map { Gender(it.key, it.value.first().name) };

        return result;
    }

    override  fun insert(gender: Gender) {
        return baseDao.insertGender(GenderEntity.from(gender))
    }

    override fun delete(gender: Gender) {
        return baseDao.deleteGender(GenderEntity.from(gender))
    }

}