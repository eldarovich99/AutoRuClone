package ru.uzbekovve.autopl.ui.screens.main

import ru.uzbekovve.autopl.base.BaseViewModel
import ru.uzbekovve.autopl.ui.custom.navigation_bar.NavigationTab

class MainViewModel :
    BaseViewModel<MainState, MainIntent, MainUiEffect>(MainState(selectedTab = NavigationTab.Chats)) {

    override suspend fun onIntent(intent: MainIntent) {
        when (intent) {
            MainIntent.NavigateChats -> setState(state.copy(selectedTab = NavigationTab.Chats))
            MainIntent.NavigateProfile -> setState(state.copy(selectedTab = NavigationTab.Profile))
        }
    }
}