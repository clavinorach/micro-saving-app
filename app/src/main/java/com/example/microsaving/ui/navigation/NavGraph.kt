package com.example.microsaving.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.microsaving.state.SavingViewModel
import com.example.microsaving.ui.screens.BerandaScreen
import com.example.microsaving.ui.screens.DaftarTujuanScreen
import com.example.microsaving.ui.screens.DetailTujuanScreen
import com.example.microsaving.ui.screens.ManajemenTujuanScreen
import com.example.microsaving.ui.screens.PengaturanScreen
import com.example.microsaving.ui.screens.RiwayatTabunganScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: SavingViewModel,
    isDarkMode: Boolean,
    onToggleDarkMode: () -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavHost(
        navController = navController,
        startDestination = Destinations.Beranda.route
    ) {
        composable(Destinations.Beranda.route) {
            BerandaScreen(
                totalSaved = viewModel.totalSaved,
                activeGoalsCount = viewModel.activeGoalsCount,
                topGoals = viewModel.topGoals,
                onViewAllGoals = {
                    navController.navigate(Destinations.DaftarTujuan.route) {
                        launchSingleTop = true
                    }
                },
                onGoalClick = { goalId ->
                    navController.navigate(Destinations.DetailTujuan.createRoute(goalId)) {
                        launchSingleTop = true
                    }
                },
                onHistoryClick = {
                    navController.navigate(Destinations.RiwayatTabungan.route) {
                        launchSingleTop = true
                    }
                },
                onSettingsClick = {
                    navController.navigate(Destinations.Pengaturan.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Destinations.DaftarTujuan.route) {
            DaftarTujuanScreen(
                goals = viewModel.goals,
                onGoalClick = { goalId ->
                    navController.navigate(Destinations.DetailTujuan.createRoute(goalId)) {
                        launchSingleTop = true
                    }
                },
                onAddGoalClick = {
                    navController.navigate(Destinations.ManajemenTujuan.route) {
                        launchSingleTop = true
                    }
                },
                onBackClick = {
                    navController.popBackStack(Destinations.Beranda.route, inclusive = false)
                }
            )
        }

        composable(
            route = Destinations.DetailTujuan.route,
            arguments = listOf(
                navArgument("goalId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val goalId = backStackEntry.arguments?.getString("goalId") ?: return@composable
            val goal = viewModel.getGoalById(goalId)
            
            if (goal != null) {
                val contributions = viewModel.getContributionsFor(goalId)
                DetailTujuanScreen(
                    goal = goal,
                    contributions = contributions,
                    onAddContribution = { amount, note ->
                        viewModel.addContribution(goalId, amount, note)
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            } else {
                // Goal not found, navigate back
                navController.popBackStack(Destinations.Beranda.route, inclusive = false)
            }
        }

        composable(Destinations.RiwayatTabungan.route) {
            RiwayatTabunganScreen(
                allContributions = viewModel.allContributions,
                onBackClick = {
                    navController.popBackStack(Destinations.Beranda.route, inclusive = false)
                }
            )
        }

        composable(Destinations.ManajemenTujuan.route) {
            ManajemenTujuanScreen(
                onAddGoal = { name, target, dueDate ->
                    viewModel.addGoal(name, target, dueDate)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Destinations.Pengaturan.route) {
            PengaturanScreen(
                darkModeEnabled = isDarkMode,
                onToggleDarkMode = onToggleDarkMode,
                onResetData = {
                    viewModel.resetAllData()
                },
                onBackClick = {
                    navController.popBackStack(Destinations.Beranda.route, inclusive = false)
                }
            )
        }
    }
}
