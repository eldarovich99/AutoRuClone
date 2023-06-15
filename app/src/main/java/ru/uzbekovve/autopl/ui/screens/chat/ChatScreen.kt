package ru.uzbekovve.autopl.ui.screens.chat

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ChatScreen(id: String) {
    Text("Chat screen, id: $id!", style = MaterialTheme.typography.h1)
}

typealias ChatId = String