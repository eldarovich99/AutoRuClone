package ru.uzbekovve.autopl.navigation.destination

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.uzbekovve.autopl.ui.screens.about_app.AboutAppScreen

const val ABOUT_APP_SCREEN = "about_app"

fun NavGraphBuilder.aboutApp(onBackPressed: () -> Unit) {
    composable(ABOUT_APP_SCREEN) {
        AboutAppScreen(onBackPressed)
    }
}

fun NavController.navigateToAboutApp() {
    navigate(ABOUT_APP_SCREEN)
}