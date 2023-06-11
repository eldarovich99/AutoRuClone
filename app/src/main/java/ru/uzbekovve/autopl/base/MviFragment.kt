package ru.uzbekovve.autopl.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class MviFragment<SF : UiEffect, VM : BaseViewModel<S, *, SF>, S : IState>(
    @LayoutRes layoutRes: Int,
) :
    Fragment(layoutRes) {

    protected abstract val viewModel: VM

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

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

    protected inline fun <reified T : ViewModel> ViewModelProvider.Factory.createOfOwner(
        viewModelStoreOwner: ViewModelStoreOwner,
        clazz: Class<T>
    ): T {
        return ViewModelProvider(viewModelStoreOwner, this)[clazz]
    }

    fun launchWhenResumed(action: suspend () -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                action()
            }
        }
    }
}