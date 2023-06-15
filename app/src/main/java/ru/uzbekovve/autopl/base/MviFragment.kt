package ru.uzbekovve.autopl.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class MviFragment<SF : UiEffect, VM : BaseViewModel<S, *, SF>, S : IState>(
    @LayoutRes layoutRes: Int,
) :
    Fragment(layoutRes) {

    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchWhenResumed {
            viewModel.stateFlow.onEach {
                renderState(it)
            }.collect()
        }
        launchWhenResumed {
            viewModel.uiEffectsFlow.onEach { uiEffect ->
                renderUiEffect(uiEffect)
            }.collect()
        }
        viewModel.onInitialized()
    }

    open fun renderState(state: S) {}
    open fun renderUiEffect(effects: SF) {}

    fun launchWhenResumed(action: suspend () -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                action()
            }
        }
    }
}