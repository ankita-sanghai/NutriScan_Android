package com.ankita.nutriscan.feature.home.model

data class DailyNutrition(
    val date: String = "",
    val totalCalories: Float = 0f,
    val totalProtein: Float = 0f,
    val totalCarbs: Float = 0f,
    val totalFat: Float = 0f,
    val goalCalories: Int = 2000,
    val goalProtein: Int = 150,
    val goalCarbs: Int = 250,
    val goalFat: Int = 65
) {
    val calorieProgress: Float get() = (totalCalories / goalCalories).coerceIn(0f, 1f)
    val proteinProgress: Float get() = (totalProtein / goalProtein).coerceIn(0f, 1f)
    val carbsProgress: Float get() = (totalCarbs / goalCarbs).coerceIn(0f, 1f)
    val fatProgress: Float get() = (totalFat / goalFat).coerceIn(0f, 1f)
    val remainingCalories: Int get() = (goalCalories - totalCalories).toInt().coerceAtLeast(0)
}
