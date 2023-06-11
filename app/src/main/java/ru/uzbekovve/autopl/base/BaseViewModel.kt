package ru.uzbekovve.autopl.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : IState, I : IIntent, SF : UiEffect>(initialState: S) :
    ViewModel() {

    private val mStateFlow: MutableStateFlow<S> = MutableStateFlow(initialState)

    val mUiEffectsFlow: MutableSharedFlow<SF> = MutableSharedFlow()
    val mIntentFlow: MutableSharedFlow<I> = MutableSharedFlow()

    val stateFlow: StateFlow<S> = mStateFlow.asStateFlow()
    val uiEffectsFlow: SharedFlow<SF> = mUiEffectsFlow.asSharedFlow()

    val state get() = stateFlow.value

    init {
        mIntentFlow.filterNotNull().onEach {
            onIntent(it)
        }.flowOn(Dispatchers.IO).launchIn(viewModelScope)
    }

    open fun onInitialized() {}

    inline fun <reified R : I> interceptIntent(): Flow<R> {
        return mIntentFlow.filterIsInstance()
    }

    protected fun setState(state: S) {
        mStateFlow.value = state
    }

    fun intent(intent: I) {
        viewModelScope.launch(Dispatchers.IO) {
            mIntentFlow.emit(intent)
        }
    }

    fun uiEffect(effect: SF) {
        viewModelScope.launch(Dispatchers.IO) {
            mUiEffectsFlow.emit(effect)
        }
    }

    protected open suspend fun onIntent(intent: I) {}

    protected fun errorHandler(action: (Throwable) -> Unit) =
        CoroutineExceptionHandler { _, throwable ->
            Log.e(
                this::class.toString(),
                "\n\n MVI ERROR - ${javaClass.simpleName} :: ${throwable.message} \n\n"
            )
            action(throwable)
        }

    protected fun ioCoroutine(
        coroutineExceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> },
        action: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            action()
        }
    }
}