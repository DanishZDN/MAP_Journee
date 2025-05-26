package com.android.example.mobileapp_journeeg9.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.android.example.mobileapp_journeeg9.ui.screens.*

sealed class Screen(val route: String) {
    object Journal : Screen("journal")
    object CreateEntry : Screen("create_entry")
    object EntryDetail : Screen("entry_detail/{entryId}") {
        fun createRoute(entryId: String) = "entry_detail/$entryId"
    }
    object EditEntry : Screen("edit_entry/{entryId}") {
        fun createRoute(entryId: String) = "edit_entry/$entryId"
    }
}

@Composable
fun JournalNavigation(
    navController: NavHostController,
    startDestination: String = Screen.Journal.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Journal.route) {
            JournalScreen(
                onNewEntry = {
                    navController.navigate(Screen.CreateEntry.route)
                },
                onEntryClick = { entryId ->
                    navController.navigate(Screen.EntryDetail.createRoute(entryId))
                }
            )
        }

        composable(Screen.CreateEntry.route) {
            CreateEntryScreen(
                onBack = {
                    navController.popBackStack()
                },
                onSave = { title, description ->
                    // TODO: Implement saving entry
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.EntryDetail.route,
            arguments = listOf(
                navArgument("entryId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val entryId = backStackEntry.arguments?.getString("entryId") ?: return@composable
            // TODO: Load entry details from ViewModel
            EntryDetailScreen(
                title = "Sample Title",
                description = "Sample Description",
                onBack = {
                    navController.popBackStack()
                },
                onEdit = {
                    navController.navigate(Screen.EditEntry.createRoute(entryId))
                }
            )
        }

        composable(
            route = Screen.EditEntry.route,
            arguments = listOf(
                navArgument("entryId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val entryId = backStackEntry.arguments?.getString("entryId") ?: return@composable
            // TODO: Load entry details from ViewModel
            EditEntryScreen(
                initialTitle = "Sample Title",
                initialDescription = "Sample Description",
                onBack = {
                    navController.popBackStack()
                },
                onSave = { title, description ->
                    // TODO: Implement saving edited entry
                    navController.popBackStack()
                },
                onDelete = {
                    // TODO: Implement entry deletion
                    navController.popBackStack(Screen.Journal.route, false)
                }
            )
        }
    }
}
