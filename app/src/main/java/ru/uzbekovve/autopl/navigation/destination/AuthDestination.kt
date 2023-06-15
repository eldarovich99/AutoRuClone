package ru.uzbekovve.autopl.navigation.destination

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.uzbekovve.autopl.ui.screens.auth.AuthScreen

private const val AUTH_SCREEN = "auth"

fun NavGraphBuilder.auth(onAuthCompleted: () -> Unit) {
    composable(AUTH_SCREEN) {
        AuthScreen(onAuthCompleted = onAuthCompleted)
    }
}

fun NavController.navigateToAuth() {
    navigate(AUTH_SCREEN)
}