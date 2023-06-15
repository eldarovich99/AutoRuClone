package ru.uzbekovve.autopl.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.uzbekovve.autopl.ui.screens.guide.GuideScreen
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

const val GUIDE_SCREEN = "guide"

fun NavGraphBuilder.main(onLastFurtherClick: () -> Unit) {
    composable(GUIDE_SCREEN) {
        AutoPlTheme { // TODO разобраться где применять тему
            GuideScreen(onLastFurtherClick = onLastFurtherClick)
        }
    }
} 