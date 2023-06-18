package ru.uzbekovve.autopl.ui.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.theme.AutoPlTheme

@Composable
fun OptionButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) =
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(30.dp),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        Text(
            text, color = Color.Black,
            style = MaterialTheme.typography.button,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp)
                .weight(1f)
        )
        Image(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.ic_arrow_forward),
            contentDescription = null
        )
    }

@Preview
@Composable
fun PreviewOptionButton() {
    AutoPlTheme {
        OptionButton(modifier = Modifier.fillMaxWidth(), text = "Изменить никнейм") {

        }
    }
}