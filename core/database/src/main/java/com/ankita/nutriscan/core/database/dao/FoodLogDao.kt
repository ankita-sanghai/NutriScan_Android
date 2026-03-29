package com.ankita.nutriscan.core.database.dao

import androidx.room.*
import com.ankita.nutriscan.core.database.entity.FoodLogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodLogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodLog(foodLog: FoodLogEntity): Long

    @Delete
    suspend fun deleteFoodLog(foodLog: FoodLogEntity)

    @Query("SELECT * FROM food_log WHERE dateKey = :dateKey ORDER BY loggedAt DESC")
    fun getFoodLogsForDate(dateKey: String): Flow<List<FoodLogEntity>>

    @Query("""
        SELECT dateKey, SUM(calories) as totalCalories, SUM(protein) as totalProtein,
        SUM(carbs) as totalCarbs, SUM(fat) as totalFat
        FROM food_log
        WHERE dateKey BETWEEN :startDate AND :endDate
        GROUP BY dateKey
        ORDER BY dateKey DESC
    """)
    fun getDailySummaries(startDate: String, endDate: String): Flow<List<DailySummary>>

    @Query("SELECT SUM(calories) FROM food_log WHERE dateKey = :dateKey")
    fun getTotalCaloriesForDate(dateKey: String): Flow<Float?>
}

data class DailySummary(
    val dateKey: String,
    val totalCalories: Float,
    val totalProtein: Float,
    val totalCarbs: Float,
    val totalFat: Float
)
