package ru.uzbekovve.autopl.navigation.destination

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.uzbekovve.autopl.ui.screens.chat.ChatId
import ru.uzbekovve.autopl.ui.screens.main.MainScreen

const val MAIN = "main"
fun NavGraphBuilder.main(onChatClick: (ChatId) -> Unit) {
    composable(MAIN) {
        MainScreen(onChatClick)
    }
}

fun NavController.navigateToMainScreen() {
    navigate(MAIN)
}