package ru.uzbekovve.autopl.ui.screens.auth

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun AuthScreen(onAuthCompleted: () -> Unit) {
    Text("Some auth screen!", style = MaterialTheme.typography.h2)
}