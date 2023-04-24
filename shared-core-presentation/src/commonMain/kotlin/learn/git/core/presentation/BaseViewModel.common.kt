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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import learn.git.core.utils.coroutines.OneTimeEvent

abstract class BaseViewModel<State, Label>(
    initialState: State,
) : ViewModel() {

    protected val mutableState = MutableStateFlow(initialState).cMutableStateFlow()
    protected val mutableLabel = OneTimeEvent<Label>()

    val state: CStateFlow<State>
        get() = mutableState.cStateFlow()

    val label: CFlow<Label>
        get() = mutableLabel.receiveAsFlow().cFlow()

    protected var binder: Binder? = null

    protected open fun acceptState(state: State) {
        mutableState.value = state
    }

    protected open fun acceptLabel(label: Label) {
        viewModelScope.launch {
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
    }
}
