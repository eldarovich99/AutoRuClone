package ru.uzbekovve.autopl.ui.screens.all_chats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.screens.all_chats.model.ChatUiModelShort
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

@Composable
fun MessageItem(modifier: Modifier = Modifier, chatUiModel: ChatUiModelShort) {
    Row(
        modifier = modifier.padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = chatUiModel.imageUrl,
            contentDescription = stringResource(id = R.string.avatar),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(67.dp)
                .clip(CircleShape),
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 15.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(text = chatUiModel.title, style = MaterialTheme.typography.body1)
            Text(text = chatUiModel.lastMessage, style = MaterialTheme.typography.subtitle2)
        }
        Box(
            modifier = Modifier
                .size(5.dp)
                .clip(CircleShape)
                .background(Color.Black),
        )
    }
}

@Preview
@Composable
fun PreviewMessageItem() {
    AutoPlTheme {
        MessageItem(
            chatUiModel = ChatUiModelShort(
                "id",
                "name_1",
                "last message text",
                false,
                "https://f30.bimmerpost.com/forums/attachment.php?attachmentid=1290197&d=1443528193",
            ),
        )
    }
}
