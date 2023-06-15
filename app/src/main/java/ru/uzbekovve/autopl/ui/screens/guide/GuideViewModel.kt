package ru.uzbekovve.autopl.ui.screens.guide

import ru.uzbekovve.autopl.base.BaseViewModel

class GuideViewModel :
    BaseViewModel<GuideState, GuideIntent, GuideUiEffect>(GuideState(GuideStep.STEP_ONE)) {
    override suspend fun onIntent(intent: GuideIntent) {
        when (intent) {
            GuideIntent.Next -> {
                setState(
                    GuideState(
                        step = GuideStep.get(state.step.value + 1) ?: GuideStep.STEP_THREE
                    )
                )
            }
        }
    }
}