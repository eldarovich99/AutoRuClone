package ru.uzbekovve.autopl.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.custom.OptionButton
import ru.uzbekovve.autopl.ui.custom.SimpleToolbar
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme
import ru.uzbekovve.autopl.ui.theme.GreyBackground

@Composable
fun ProfileScreen(
    onUserNameClicked: () -> Unit,
    onAboutAppClicked: () -> Unit,
    onLogoutClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleToolbar(modifier = Modifier.padding(bottom = 16.dp), stringRes = R.string.profile)
        Box(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.grey))
        )
        AsyncImage(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(210.dp)
                .clip(CircleShape),
            model = "https://f30.bimmerpost.com/forums/attachment.php?attachmentid=1290197&d=1443528193",
            contentDescription = stringResource(id = R.string.avatar),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(21.dp),
            text = "nickname",
            style = MaterialTheme.typography.h3
        ) // TODO use text from viewModel
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
        ) {
            OptionButton(
                text = stringResource(id = R.string.profile_change_nickname),
                onClick = onUserNameClicked
            )
            OptionButton(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(id = R.string.profile_about_app),
                onClick = onAboutAppClicked
            )
            OptionButton(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(id = R.string.profile_logout),
                onClick = onLogoutClicked
            )
        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    AutoPlTheme {
        ProfileScreen(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GreyBackground),
            onUserNameClicked = {},
            onAboutAppClicked = {},
            onLogoutClicked = {})
    }
}