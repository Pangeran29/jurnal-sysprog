package org.d3if3030.mobpro1_compose.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.d3if3030.mobpro1_compose.ui.screen.Dashboard
import org.d3if3030.mobpro1_compose.ui.screen.DetailScreen
import org.d3if3030.mobpro1_compose.ui.screen.MainScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ) {
        composable(
            route = Screen.Home.route,
            arguments = listOf(navArgument("book") { type = NavType.StringType })
        ) {
            val arguments = requireNotNull(it.arguments)
            val book = arguments.getString("book")
            if (book != null) {
                MainScreen(navController, book)
            }
        }
        composable(
            route = Screen.FormBaru.route,
            arguments = listOf(navArgument("book") { type = NavType.StringType })
        ) {
            val arguments = requireNotNull(it.arguments)
            val book = arguments.getString("book")
            if (book != null) {
                DetailScreen(navController, book)
            }
        }
        composable(
            route = Screen.FormUbah.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType }, navArgument("book") { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val id = arguments.getLong("id")
            val book = arguments.getString("book")
            if (book != null) {
                DetailScreen(navController, book, id)
            }
        }
        composable(route = Screen.Dashboard.route) {
            Dashboard(navController)
        }
    }
}