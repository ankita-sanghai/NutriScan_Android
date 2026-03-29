package com.ankita.nutriscan.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ankita.nutriscan.feature.home.HomeScreen
import com.ankita.nutriscan.feature.diary.DiaryScreen
import com.ankita.nutriscan.feature.search.SearchScreen
import com.ankita.nutriscan.feature.profile.ProfileScreen

@Composable
fun NutriScanNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = TopLevelDestination.Home.route,
        modifier = modifier
    ) {
        composable(TopLevelDestination.Home.route) {
            HomeScreen(
                onNavigateToSearch = {
                    navController.navigate(TopLevelDestination.Search.route)
                }
            )
        }
        composable(TopLevelDestination.Diary.route) {
            DiaryScreen()
        }
        composable(TopLevelDestination.Search.route) {
            SearchScreen()
        }
        composable(TopLevelDestination.Profile.route) {
            ProfileScreen()
        }
    }
}
