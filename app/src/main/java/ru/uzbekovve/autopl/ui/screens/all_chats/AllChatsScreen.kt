package ru.uzbekovve.autopl.ui.screens.all_chats

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ru.uzbekovve.autopl.ui.screens.chat.ChatId

@Composable
fun AllChatsScreen(onChatClick: (ChatId) -> Unit) {
    Text("All chats screen", style = MaterialTheme.typography.h1)
}