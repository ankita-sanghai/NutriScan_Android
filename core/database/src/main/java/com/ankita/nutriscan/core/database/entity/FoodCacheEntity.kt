package com.ankita.nutriscan.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_cache")
data class FoodCacheEntity(
    @PrimaryKey val foodId: String,
    val foodName: String,
    val brandName: String?,
    val calories: Float,
    val protein: Float,
    val carbs: Float,
    val fat: Float,
    val fiber: Float,
    val servingSize: Float,
    val servingUnit: String,
    val barcode: String?,
    val imageUrl: String?,
    val cachedAt: Long = System.currentTimeMillis()
)
