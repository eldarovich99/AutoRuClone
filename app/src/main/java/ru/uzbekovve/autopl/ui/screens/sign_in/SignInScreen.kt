package ru.uzbekovve.autopl.ui.screens.sign_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.custom.ShoutButton
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

@Composable
fun SignInScreen(onSignInCompleted: () -> Unit) {
    // TODO add ViewModel for auth
    AutoPlTheme {
        Column {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name_dot),
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                )
            }
            ShoutButton(
                text = stringResource(id = R.string.sign_in_with_google),
                onClick = onSignInCompleted
            )
        }
    }
}