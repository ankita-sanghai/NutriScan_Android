package com.ankita.nutriscan.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_goal")
data class UserGoalEntity(
    @PrimaryKey val id: Int = 1,
    val dailyCalories: Int = 2000,
    val dailyProtein: Int = 150,
    val dailyCarbs: Int = 250,
    val dailyFat: Int = 65,
    val dailyFiber: Int = 30
)
