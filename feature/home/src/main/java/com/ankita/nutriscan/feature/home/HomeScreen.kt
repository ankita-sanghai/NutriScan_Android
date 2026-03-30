package com.ankita.nutriscan.feature.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ankita.nutriscan.feature.home.model.DailyNutrition

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToSearch: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NutriScan", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.QrCodeScanner, contentDescription = "Scan barcode")
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onNavigateToSearch,
                icon = { Icon(Icons.Default.QrCodeScanner, contentDescription = null) },
                text = { Text("Add Food") }
            )
        }
    ) { padding ->
        if (uiState.isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalorieRingCard(nutrition = uiState.dailyNutrition)
                MacrosSummaryRow(nutrition = uiState.dailyNutrition)
                listOf("Breakfast", "Lunch", "Dinner", "Snacks").forEach { meal ->
                    MealSectionCard(title = meal, calories = 0f)
                }
                Spacer(Modifier.height(80.dp))
            }
        }
    }
}

@Composable
private fun CalorieRingCard(nutrition: DailyNutrition) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val trackColor = MaterialTheme.colorScheme.surfaceVariant

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Today", style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(Modifier.height(16.dp))
            Box(contentAlignment = Alignment.Center) {
                Canvas(modifier = Modifier.size(160.dp)) {
                    val strokeWidth = 16.dp.toPx()
                    val inset = strokeWidth / 2
                    val arcSize = Size(size.width - strokeWidth, size.height - strokeWidth)
                    val topLeft = Offset(inset, inset)
                    drawArc(color = trackColor, startAngle = -220f, sweepAngle = 260f,
                        useCenter = false, topLeft = topLeft, size = arcSize,
                        style = Stroke(strokeWidth, cap = StrokeCap.Round))
                    drawArc(color = primaryColor, startAngle = -220f,
                        sweepAngle = 260f * nutrition.calorieProgress,
                        useCenter = false, topLeft = topLeft, size = arcSize,
                        style = Stroke(strokeWidth, cap = StrokeCap.Round))
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(nutrition.totalCalories.toInt().toString(),
                        fontSize = 36.sp, fontWeight = FontWeight.Bold)
                    Text("kcal eaten", style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Spacer(Modifier.height(4.dp))
                    Text("${nutrition.remainingCalories} remaining",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary)
                }
            }
            Spacer(Modifier.height(8.dp))
            Text("Goal: ${nutrition.goalCalories} kcal",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun MacrosSummaryRow(nutrition: DailyNutrition) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        MacroCard("Protein", nutrition.totalProtein.toInt(), nutrition.goalProtein,
            nutrition.proteinProgress, MaterialTheme.colorScheme.tertiary, Modifier.weight(1f))
        MacroCard("Carbs", nutrition.totalCarbs.toInt(), nutrition.goalCarbs,
            nutrition.carbsProgress, MaterialTheme.colorScheme.secondary, Modifier.weight(1f))
        MacroCard("Fat", nutrition.totalFat.toInt(), nutrition.goalFat,
            nutrition.fatProgress, Color(0xFFE91E63), Modifier.weight(1f))
    }
}

@Composable
private fun MacroCard(label: String, current: Int, goal: Int, progress: Float,
    color: Color, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(label, style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(Modifier.height(4.dp))
            Text("${current}g", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text("/ ${goal}g", style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(Modifier.height(8.dp))
            LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth(),
                color = color, trackColor = color.copy(alpha = 0.2f))
        }
    }
}

@Composable
private fun MealSectionCard(title: String, calories: Float) {
    Card(modifier = Modifier.fillMaxWidth()) {
        ListItem(
            headlineContent = { Text(title, fontWeight = FontWeight.Medium) },
            supportingContent = {
                Text(if (calories > 0) "${calories.toInt()} kcal" else "No items logged",
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            },
            trailingContent = { TextButton(onClick = {}) { Text("+ Add") } }
        )
    }
}
