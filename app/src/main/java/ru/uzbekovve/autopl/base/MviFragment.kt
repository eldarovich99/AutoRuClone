package ru.uzbekovve.autopl.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class MviFragment<VM : BaseViewModel<S, *>, S : IState> :
    Fragment() {

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
        onViewCreated()
        viewModel.onInitialized()
    }

    abstract fun onViewCreated()
    open fun renderState(state: S) {}

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