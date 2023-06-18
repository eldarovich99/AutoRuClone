package ru.uzbekovve.autopl.ui.screens.guide

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.uzbekovve.autopl.R
import ru.uzbekovve.autopl.ui.custom.GuideIndicator
import ru.uzbekovve.autopl.ui.custom.ShoutButton
import ru.uzbekovve.autopl.ui.custom.SimpleToolbar

@Composable
fun GuideScreen(
    modifier: Modifier = Modifier,
    viewModel: GuideViewModel = koinViewModel(),
    onLastFurtherClick: () -> Unit
) {
    val state = viewModel.stateFlow.collectAsState()

    Column(
        modifier = modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SimpleToolbar(modifier = modifier, stringRes = R.string.shout_is)
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(id = R.string.shout_description_1),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(horizontal = 30.dp)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            GuideIndicator(
                modifier = Modifier
                    .height(3.dp)
                    .width(47.dp),
                enabled = state.value.step == GuideStep.STEP_ONE
            )
            GuideIndicator(
                modifier = Modifier
                    .height(3.dp)
                    .width(47.dp),
                enabled = state.value.step == GuideStep.STEP_TWO
            )
            GuideIndicator(
                modifier = Modifier
                    .height(3.dp)
                    .width(47.dp),
                enabled = state.value.step == GuideStep.STEP_THREE
            )
        }
        ShoutButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            text = stringResource(id = R.string.next_button),
            onClick = {
                if (state.value.step == GuideStep.STEP_THREE) onLastFurtherClick.invoke() else
                    viewModel.intent(GuideIntent.Next)
            })
    }
}