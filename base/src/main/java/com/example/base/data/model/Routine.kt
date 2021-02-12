package com.example.base.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "traineeRoutine")
data class Routine(
    @PrimaryKey(autoGenerate = true)
    val routineId: Int,
    @ColumnInfo(name = "due_day")
    val dueDay: Date,
    @ColumnInfo(name = "wtf")
    val exercises: String)