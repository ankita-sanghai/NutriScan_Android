package com.ankita.nutriscan.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ankita.nutriscan.core.database.dao.FoodCacheDao
import com.ankita.nutriscan.core.database.dao.FoodLogDao
import com.ankita.nutriscan.core.database.entity.FoodCacheEntity
import com.ankita.nutriscan.core.database.entity.FoodLogEntity
import com.ankita.nutriscan.core.database.entity.UserGoalEntity

@Database(
    entities = [FoodLogEntity::class, FoodCacheEntity::class, UserGoalEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NutriScanDatabase : RoomDatabase() {
    abstract fun foodLogDao(): FoodLogDao
    abstract fun foodCacheDao(): FoodCacheDao
}
