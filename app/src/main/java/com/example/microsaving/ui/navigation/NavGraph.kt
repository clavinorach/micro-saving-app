package com.example.microsaving.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                    navController.navigate(Destinations.DaftarTujuan.route)
                },
                onGoalClick = { goalId ->
                    navController.navigate(Destinations.DetailTujuan.createRoute(goalId))
                },
                onHistoryClick = {
                    navController.navigate(Destinations.RiwayatTabungan.route)
                },
                onSettingsClick = {
                    navController.navigate(Destinations.Pengaturan.route)
                }
            )
        }

        composable(Destinations.DaftarTujuan.route) {
            DaftarTujuanScreen(
                goals = viewModel.goals,
                onGoalClick = { goalId ->
                    navController.navigate(Destinations.DetailTujuan.createRoute(goalId))
                },
                onAddGoalClick = {
                    navController.navigate(Destinations.ManajemenTujuan.route)
                },
                onBackClick = {
                    navController.popBackStack()
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
            val goal = viewModel.getGoalById(goalId) ?: return@composable
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
        }

        composable(Destinations.RiwayatTabungan.route) {
            RiwayatTabunganScreen(
                allContributions = viewModel.allContributions,
                onBackClick = {
                    navController.popBackStack()
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
                    navController.popBackStack()
                }
            )
        }
    }
}
