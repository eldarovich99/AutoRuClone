package ru.uzbekovve.autopl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import ru.uzbekovve.autopl.navigation.ShoutAppNavigation
import ru.uzbekovve.autopl.ui.screens.guide.GuideScreen
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            ShoutAppNavigation(navController = navController)
        }
    }
}