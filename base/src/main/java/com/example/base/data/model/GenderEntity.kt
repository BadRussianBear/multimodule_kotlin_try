package com.example.base.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.shared.Gender

@Entity
data class GenderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String
) {
    companion object {
        fun from(user: Gender): GenderEntity {
            return GenderEntity(user.id, user.name)
        }

        fun to(user: GenderEntity): Gender {
            return Gender(user.id, user.name)
        }
    }
}