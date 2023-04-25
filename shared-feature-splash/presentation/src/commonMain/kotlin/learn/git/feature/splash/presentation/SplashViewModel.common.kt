package learn.git.feature.splash.presentation

import io.github.aakira.napier.Napier
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import learn.git.core.navigation.NavGraph
import learn.git.core.presentation.BaseViewModel
import learn.git.core.utils.coroutines.OneTimeEvent
import learn.git.feature.splash.api.SplashUseCase

class SplashViewModel(
    private val splashUseCase: SplashUseCase
) : BaseViewModel<Any, Any>(Any()) {

    private val mutableNavigation = OneTimeEvent<NavGraph>()
    val navigation: Flow<NavGraph>
        get() = mutableNavigation.receiveAsFlow()

    init {
        scope.launch {
            delay(500)
            runCatching {
                splashUseCase.isFirstLaunch()
            }.onSuccess { isFirstLaunch ->
                val destination = if (isFirstLaunch) NavGraph.Onboarding else NavGraph.Levels
                mutableNavigation.send(destination)
            }.onFailure { throwable ->
                Napier.e(message = "Check is first launch error", throwable = throwable)
                mutableNavigation.send(NavGraph.Levels)
            }
        }
    }
}
