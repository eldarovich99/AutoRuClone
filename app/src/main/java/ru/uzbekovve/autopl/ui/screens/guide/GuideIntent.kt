package ru.uzbekovve.autopl.ui.screens.guide

import ru.uzbekovve.autopl.base.IIntent

sealed interface GuideIntent: IIntent {
    object Next: GuideIntent
}