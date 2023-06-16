package ru.uzbekovve.autopl.navigation.destination

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.uzbekovve.autopl.ui.screens.sign_in.SignInScreen
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

private const val SIGN_IN_SCREEN = "sign_in"

fun NavGraphBuilder.signIn(onSignInCompleted: () -> Unit) {
    composable(SIGN_IN_SCREEN) {
        SignInScreen(onSignInCompleted)
    }
}

fun NavController.navigateSignIn() {
    navigate(SIGN_IN_SCREEN)
}