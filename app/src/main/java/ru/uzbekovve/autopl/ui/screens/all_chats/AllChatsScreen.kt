package ru.uzbekovve.autopl.ui.screens.all_chats

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.navigation.koinNavViewModel
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.custom.SimpleToolbar
import ru.uzbekovve.autopl.ui.screens.chat.ChatId

@Composable
fun AllChatsScreen(
    onChatClick: (ChatId) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AllChatsViewModel = koinNavViewModel(),
) {
    val state = viewModel.stateFlow.collectAsState()
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SimpleToolbar(modifier = Modifier.padding(bottom = 16.dp), stringRes = R.string.chats)
        Box(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.grey)),
        )
        if (state.value is AllChatsState.Loaded) {
            val listState = rememberLazyListState()
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                itemsIndexed((state.value as AllChatsState.Loaded).chats) { index, chatUiModel ->
                    MessageItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onChatClick.invoke(chatUiModel.id)
                            },
                        chatUiModel = chatUiModel,
                    )
                }
            }
        }
    }
}
