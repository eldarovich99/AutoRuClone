package ru.uzbekovve.autopl.ui.screens.all_chats

import ru.uzbekovve.autopl.base.IState
import ru.uzbekovve.autopl.ui.screens.all_chats.model.ChatUiModelShort

sealed interface AllChatsState : IState {
    object Loading : AllChatsState
    class Loaded(val chats: List<ChatUiModelShort>) : AllChatsState
    object Error : AllChatsState
}