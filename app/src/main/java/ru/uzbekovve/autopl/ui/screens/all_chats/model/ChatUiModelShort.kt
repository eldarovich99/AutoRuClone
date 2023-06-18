package ru.uzbekovve.autopl.ui.screens.all_chats.model

import ru.uzbekovve.autopl.ui.screens.chat.ChatId

data class ChatUiModelShort(
    val id: ChatId,
    val title: String,
    val lastMessage: String,
    val isRead: Boolean,
    val imageUrl: String
)