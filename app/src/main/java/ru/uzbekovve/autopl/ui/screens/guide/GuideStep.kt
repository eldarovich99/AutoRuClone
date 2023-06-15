package ru.uzbekovve.autopl.ui.screens.guide

enum class GuideStep(val value: Int) {
    STEP_ONE(1),
    STEP_TWO(2),
    STEP_THREE(3);

    companion object {
        private val map = GuideStep.values().associateBy { it.value }
        operator fun get(value: Int) = map[value]
    }
}