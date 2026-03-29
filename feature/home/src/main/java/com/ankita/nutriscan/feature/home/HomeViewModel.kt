package com.ankita.nutriscan.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankita.nutriscan.core.database.dao.FoodLogDao
import com.ankita.nutriscan.feature.home.model.DailyNutrition
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

data class HomeUiState(
    val isLoading: Boolean = true,
    val dailyNutrition: DailyNutrition = DailyNutrition(),
    val todayKey: String = ""
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodLogDao: FoodLogDao
) : ViewModel() {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val todayKey get() = dateFormat.format(Date())

    val uiState: StateFlow<HomeUiState> = foodLogDao
        .getFoodLogsForDate(todayKey)
        .map { logs ->
            val nutrition = DailyNutrition(
                date = todayKey,
                totalCalories = logs.sumOf { it.calories.toDouble() }.toFloat(),
                totalProtein = logs.sumOf { it.protein.toDouble() }.toFloat(),
                totalCarbs = logs.sumOf { it.carbs.toDouble() }.toFloat(),
                totalFat = logs.sumOf { it.fat.toDouble() }.toFloat(),
            )
            HomeUiState(isLoading = false, dailyNutrition = nutrition, todayKey = todayKey)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState()
        )
}
