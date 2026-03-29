package com.ankita.nutriscan.core.database.di

import android.content.Context
import androidx.room.Room
import com.ankita.nutriscan.core.database.NutriScanDatabase
import com.ankita.nutriscan.core.database.dao.FoodCacheDao
import com.ankita.nutriscan.core.database.dao.FoodLogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NutriScanDatabase =
        Room.databaseBuilder(context, NutriScanDatabase::class.java, "nutriscan_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideFoodLogDao(db: NutriScanDatabase): FoodLogDao = db.foodLogDao()

    @Provides
    fun provideFoodCacheDao(db: NutriScanDatabase): FoodCacheDao = db.foodCacheDao()
}
