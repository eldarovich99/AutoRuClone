package ru.uzbekovve.autopl.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

object FlowUtils {

    fun <T> Flow<T>.singleOrNullIn(scope: CoroutineScope) {
        scope.launch {
            singleOrNull()
        }
    }

    fun <T> StateFlow<T?>.requireValue(): T {
        return value ?: throw IllegalArgumentException("No value in StateFlow!")
    }
}