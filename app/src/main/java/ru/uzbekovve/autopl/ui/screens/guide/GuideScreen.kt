package ru.uzbekovve.autopl.ui.screens.guide

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
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
        Text(
            text = stringResource(id = R.string.shout_is),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(top = 24.dp)
        )
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(id = R.string.shout_description_1),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 30.dp)
            )
        }
        Row {
            GuideIndicator(enabled = state.value.step == GuideStep.STEP_ONE)
            GuideIndicator(
                modifier = Modifier.padding(horizontal = 20.dp),
                enabled = state.value.step == GuideStep.STEP_TWO
            )
            GuideIndicator(enabled = state.value.step == GuideStep.STEP_THREE)
        }
        ShoutButton(
            text = stringResource(id = R.string.next_button),
            onClick = {
                if (state.value.step == GuideStep.STEP_THREE) onLastFurtherClick.invoke() else
                    viewModel.intent(GuideIntent.Next)
            })
    }
}