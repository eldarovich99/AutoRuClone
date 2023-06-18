package ru.uzbekovve.autopl.ui.custom.navigation_bar

sealed interface NavigationTab {
    object Chats: NavigationTab
    object Profile: NavigationTab
}