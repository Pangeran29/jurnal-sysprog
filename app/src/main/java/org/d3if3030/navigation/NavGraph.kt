package org.d3if3030.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.d3if3030.jurnal_sysprog.ui.screen.MainScreen
import org.d3if3030.jurnal_sysprog.ui.screen.UpdateJournalScreen

@Composable
fun SetUpNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            MainScreen(navController)
        }
        composable(route = Screen.UpdateJurnal.route) {
            UpdateJournalScreen(navController)
        }
    }
}