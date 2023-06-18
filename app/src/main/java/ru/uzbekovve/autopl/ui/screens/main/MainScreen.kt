package ru.uzbekovve.autopl.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.uzbekovve.autopl.ui.custom.navigation_bar.NavigationBar
import ru.uzbekovve.autopl.ui.custom.navigation_bar.NavigationTab
import ru.uzbekovve.autopl.ui.screens.all_chats.AllChatsScreen
import ru.uzbekovve.autopl.ui.screens.chat.ChatId
import ru.uzbekovve.autopl.ui.screens.profile.ProfileScreen
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme
import ru.uzbekovve.autopl.ui.theme.GreyBackground

@Composable
fun MainScreen(
    onChatClick: (ChatId) -> Unit,
    onUserNameClicked: () -> Unit,
    onAboutAppClicked: () -> Unit,
    onLogoutClicked: () -> Unit,
    mainViewModel: MainViewModel = koinViewModel()
) {
    val state = mainViewModel.stateFlow.collectAsState()

    AutoPlTheme {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(GreyBackground),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (state.value.selectedTab) {
                NavigationTab.Chats -> AllChatsScreen(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    onChatClick = onChatClick
                )

                NavigationTab.Profile -> ProfileScreen(
                    onUserNameClicked = onUserNameClicked,
                    onAboutAppClicked = onAboutAppClicked,
                    onLogoutClicked = onLogoutClicked,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                )

                else -> throw NotImplementedError("Not implemented yet")
            }
            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
                state.value.selectedTab
            ) { selectedTab ->
                when (selectedTab) {
                    NavigationTab.Profile -> mainViewModel.intent(MainIntent.NavigateProfile)
                    NavigationTab.Chats -> mainViewModel.intent(MainIntent.NavigateChats)
                }
            }
        }
    }
}