package ru.uzbekovve.autopl.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.uzbekovve.autopl.ui.theme.Grey

@Composable
fun GuideIndicator(modifier: Modifier = Modifier, enabled: Boolean) =
    Box(
        modifier
            .clip(RoundedCornerShape(1.5.dp))
            .background(if (enabled) Color.Black else Grey)
    )