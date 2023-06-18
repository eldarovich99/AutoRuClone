package ru.uzbekovve.autopl.ui.custom

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

@Composable
fun SimpleToolbar(modifier: Modifier = Modifier, @StringRes stringRes: Int) {
    Text(
        text = stringResource(stringRes),
        style = MaterialTheme.typography.h2,
        modifier = modifier.padding(top = 24.dp)
    )
}

@Preview
@Composable
fun PreviewToolbar() {
    AutoPlTheme {
        SimpleToolbar(stringRes = R.string.chats)
    }
}