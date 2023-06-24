package ru.uzbekovve.autopl.ui.screens.about_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.custom.OptionButton
import ru.uzbekovve.autopl.ui.custom.SimpleToolbar
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

@Composable
fun AboutAppScreen(onBackPressed: () -> Unit) {
    AutoPlTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleToolbar(
                stringRes = R.string.profile_about_app,
                modifier = Modifier.fillMaxWidth(),
                backButtonEnabled = true,
                onBackPressed = onBackPressed
            )
            Text(
                modifier = Modifier.padding(vertical = 70.dp),
                text = stringResource(id = R.string.app_name_dot),
                style = MaterialTheme.typography.h1
            )
            Text(
                text = stringResource(id = R.string.about_app_main),
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(id = R.string.about_app_subtitle),
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center
            )
            OptionButton(text = stringResource(id = R.string.about_app_support)) {
                TODO("Not implemented")
            }
        }

    }
}