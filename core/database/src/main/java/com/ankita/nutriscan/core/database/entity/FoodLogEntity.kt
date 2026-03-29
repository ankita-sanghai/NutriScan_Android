package com.ankita.nutriscan.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_log")
data class FoodLogEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val foodId: String,
    val foodName: String,
    val brandName: String?,
    val calories: Float,
    val protein: Float,
    val carbs: Float,
    val fat: Float,
    val fiber: Float,
    val servingSize: Float,
    val servingUnit: String,
    val mealType: String, // BREAKFAST, LUNCH, DINNER, SNACK
    val loggedAt: Long = System.currentTimeMillis(),
    val dateKey: String // "yyyy-MM-dd" for easy daily queries
)
