package ru.uzbekovve.autopl.ui.custom

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

@Composable
fun SimpleToolbar(
    modifier: Modifier = Modifier,
    @StringRes stringRes: Int,
    backButtonEnabled: Boolean = false,
    onBackPressed: (() -> Unit)? = null
) {
    Row(
        modifier = modifier.padding(start = 48.dp, end = 48.dp, top = 24.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        if (backButtonEnabled) {
            Image(
                modifier = Modifier
                    .size(16.dp)
                    .clickable {
                        onBackPressed?.invoke()
                    }
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = stringResource(
                    id = R.string.back
                )
            )
        }
        Text(
            text = stringResource(stringRes),
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Preview("Default toolbar")
@Composable
fun PreviewToolbar() {
    AutoPlTheme {
        SimpleToolbar(stringRes = R.string.chats, modifier = Modifier.fillMaxWidth())
    }
}

@Preview("Toolbar with back arrow")
@Composable
fun PreviewToolbarWithArrow() {
    AutoPlTheme {
        SimpleToolbar(stringRes = R.string.chats, backButtonEnabled = true)
    }
}