package ru.uzbekovve.autopl.ui.screens.guide

import ru.uzbekovve.autopl.base.BaseViewModel

class GuideViewModel :
    BaseViewModel<GuideState, GuideIntent, GuideUiEffect>(GuideState(GuideStep.STEP_ONE)) {
}