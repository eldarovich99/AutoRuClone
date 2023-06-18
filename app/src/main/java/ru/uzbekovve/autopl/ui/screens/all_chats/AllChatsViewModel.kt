package ru.uzbekovve.autopl.ui.screens.all_chats

import ru.uzbekovve.autopl.base.BaseViewModel
import ru.uzbekovve.autopl.ui.screens.all_chats.model.ChatUiModelShort

class AllChatsViewModel : BaseViewModel<AllChatsState, AllChatsIntent, AllChatsUiEffect>(
    AllChatsState.Loading
) {
    init {
        setState(AllChatsState.Loaded(mockChats()))
    }

    private fun mockChats(): List<ChatUiModelShort> {
        return listOf(
            ChatUiModelShort(
                "id",
                "name_1",
                "last message text",
                false,
                "https://f30.bimmerpost.com/forums/attachment.php?attachmentid=1290197&d=1443528193"
            ),
            ChatUiModelShort(
                "id",
                "name_2",
                "last message text",
                false,
                "https://f30.bimmerpost.com/forums/attachment.php?attachmentid=1290197&d=1443528193"
            ),
            ChatUiModelShort(
                "id",
                "name_3",
                "last message text",
                false,
                "https://f30.bimmerpost.com/forums/attachment.php?attachmentid=1290197&d=1443528193"
            )
        )
    }
}