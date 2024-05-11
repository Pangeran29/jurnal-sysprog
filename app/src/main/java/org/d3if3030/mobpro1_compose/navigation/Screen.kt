package org.d3if3030.mobpro1_compose.navigation

sealed class Screen(val route: String) {
    object Home: Screen("mainScreen/{book}") {
        fun withBook(book: String) = "mainScreen/$book"
    }
    object FormBaru: Screen("detailScreen/{book}") {
        fun withBook(book: String) = "detailScreen/$book"
    }
    object FormUbah : Screen("detailScreen/{id}/{book}") {
        fun withId(id: Long, book: String) = "detailScreen/$id/$book"
    }
    object Dashboard: Screen("dashboard")
}