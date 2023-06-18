package ru.uzbekovve.autopl.ui.screens.main

import ru.uzbekovve.autopl.base.IIntent

sealed interface MainIntent : IIntent {
    object NavigateChats : MainIntent
    object NavigateProfile : MainIntent
}