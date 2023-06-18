package ru.uzbekovve.autopl.ui.screens.main

import ru.uzbekovve.autopl.base.BaseViewModel
import ru.uzbekovve.autopl.ui.custom.navigation_bar.NavigationTab

class MainViewModel :
    BaseViewModel<MainState, MainIntent, MainUiEffect>(MainState(selectedTab = NavigationTab.Chats))