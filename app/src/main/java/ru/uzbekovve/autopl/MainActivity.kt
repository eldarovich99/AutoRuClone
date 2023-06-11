package ru.uzbekovve.autopl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.uzbekovve.autopl.ui.screens.guide.GuideScreen
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutoPlTheme {
                // A surface container using the 'background' color from the theme
                GuideScreen()
            }
        }
    }
}