package ru.uzbekovve.autopl.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.custom.ShoutButton
import ru.uzbekovve.autopl.ui.custom.SimpleToolbar
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

@Composable
fun AuthScreen(onAuthCompleted: () -> Unit) {
    AutoPlTheme {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SimpleToolbar(stringRes = R.string.your_username)
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                val nicknameValue by remember { mutableStateOf("") }
                TextField(
                    value = nicknameValue,
                    onValueChange = {},
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                    ),
                    placeholder = {
                        Text(
                            stringResource(id = R.string.type_username),
                            style = MaterialTheme.typography.body1,
                        )
                    },
                )
            }
            ShoutButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                text = stringResource(id = R.string.done),
                onClick = onAuthCompleted,
            )
        }
    }
}

@Preview("Preview screen")
@Composable
fun PreviewAuthScreen() {
    AuthScreen {}
}

@Preview
@Composable
fun DumbPreview() {
    // TODO delete later
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(Color.Blue)
                .fillMaxWidth(),
        )
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(Color.Red)
                .fillMaxWidth(),
        )
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(Color.Blue)
                .fillMaxWidth(),
        )
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(Color.Red)
                .fillMaxWidth(),
        )
    }
}
