package com.ankita.nutriscan.core.database.dao

import androidx.room.*
import com.ankita.nutriscan.core.database.entity.FoodCacheEntity

@Dao
interface FoodCacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: FoodCacheEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoods(foods: List<FoodCacheEntity>)

    @Query("SELECT * FROM food_cache WHERE foodId = :foodId")
    suspend fun getFoodById(foodId: String): FoodCacheEntity?

    @Query("SELECT * FROM food_cache WHERE barcode = :barcode LIMIT 1")
    suspend fun getFoodByBarcode(barcode: String): FoodCacheEntity?

    @Query("SELECT * FROM food_cache WHERE foodName LIKE '%' || :query || '%' LIMIT 20")
    suspend fun searchFoods(query: String): List<FoodCacheEntity>

    @Query("DELETE FROM food_cache WHERE cachedAt < :cutoff")
    suspend fun deleteOldCache(cutoff: Long)
}
