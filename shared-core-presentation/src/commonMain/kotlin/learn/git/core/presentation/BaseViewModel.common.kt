package learn.git.core.presentation

import com.arkivanov.mvikotlin.core.binder.Binder
import com.arkivanov.mvikotlin.extensions.coroutines.BindingsBuilder
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import learn.git.core.utils.coroutines.OneTimeEvent
import learn.git.core.utils.coroutines.mainDispatcher

abstract class BaseViewModel<State, Label>(
    initialState: State,
) : ViewModel() {

    protected val mutableState = MutableStateFlow(initialState).cMutableStateFlow()
    protected val mutableLabel = OneTimeEvent<Label>()

    val state: CStateFlow<State>
        get() = mutableState.cStateFlow()

    val label: CFlow<Label>
        get() = mutableLabel.receiveAsFlow().cFlow()

    // TODO: remove when fixing this - https://github.com/icerockdev/moko-mvvm/issues/236
    val scope = CoroutineScope(mainDispatcher)

    protected var binder: Binder? = null

    protected open fun acceptState(state: State) {
        mutableState.value = state
    }

    protected open fun acceptLabel(label: Label) {
        scope.launch {
            mutableLabel.send(label)
        }
    }

    protected fun bindAndStart(
        mainContext: CoroutineContext = Dispatchers.Main.immediate,
        builder: BindingsBuilder.() -> Unit
    ) = bind(mainContext, builder).apply {
        start()
        binder = this
    }

    override fun onCleared() {
        super.onCleared()
        binder?.stop()
        scope.cancel()
    }
}
