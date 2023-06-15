package ru.uzbekovve.autopl.navigation.destination

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.uzbekovve.autopl.ui.screens.all_chats.AllChatsScreen
import ru.uzbekovve.autopl.ui.screens.chat.ChatId

private const val ALL_CHATS_SCREEN = "all_chats"
fun NavGraphBuilder.allChats(onChatClick: (ChatId) -> Unit) {
    composable(ALL_CHATS_SCREEN) {
        AllChatsScreen(onChatClick)
    }
}

fun NavController.navigateToAllChats() {
    navigate(ALL_CHATS_SCREEN)
}