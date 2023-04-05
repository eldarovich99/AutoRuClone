package ru.uzbekovve.autopl.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.uzbekovve.autopl.extensions.FlowUtils.requireValue

abstract class BaseViewModel<S : IState, I : IIntent>(initialState: S) : ViewModel() {

    protected val mStateFlow: MutableStateFlow<S> = MutableStateFlow(initialState)
    val stateFlow: StateFlow<S> = mStateFlow.asStateFlow()
    val state get() = stateFlow.requireValue()

    val mIntentFlow: MutableSharedFlow<I> = MutableSharedFlow(0)

    fun intent(intent: I) {
        viewModelScope.launch(IO) {
            mIntentFlow.emit(intent)
        }
    }

    open fun onInitialized() {}

    inline fun <reified R : I> interceptIntent(): Flow<R> {
        return mIntentFlow.filterIsInstance()
    }

    protected fun setState(state: S) {
        mStateFlow.value = state
    }

    protected open suspend fun onIntent(intent: I) {}

    protected fun errorHandler(action: (Throwable) -> Unit) =
        CoroutineExceptionHandler { _, throwable ->
            action(throwable)
        }

    protected fun ioCoroutine(
        coroutineExceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> },
        action: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch(IO + coroutineExceptionHandler) {
            action()
        }
    }

    init {
        mIntentFlow.filterNotNull().onEach {
            onIntent(it)
        }.flowOn(IO).launchIn(viewModelScope)
    }
}