package com.ankita.nutriscan.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TopLevelDestination(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : TopLevelDestination("home", "Home", Icons.Default.Home)
    object Diary : TopLevelDestination("diary", "Diary", Icons.Default.MenuBook)
    object Search : TopLevelDestination("search", "Search", Icons.Default.Search)
    object Profile : TopLevelDestination("profile", "Profile", Icons.Default.Person)
}
