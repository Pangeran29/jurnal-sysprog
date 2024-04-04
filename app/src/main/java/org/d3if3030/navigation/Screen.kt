package org.d3if3030.navigation

sealed class Screen(val route: String) {
    object Home: Screen("mainScreen")
    object UpdateJurnal: Screen("updateJournalScreen")
}