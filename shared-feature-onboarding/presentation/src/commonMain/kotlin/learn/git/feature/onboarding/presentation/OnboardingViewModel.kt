package learn.git.feature.onboarding.presentation

import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import learn.git.core.navigation.NavGraph
import learn.git.core.presentation.BaseViewModel
import learn.git.core.utils.coroutines.OneTimeEvent
import learn.git.feature.onboarding.api.OnboardingUseCase

class OnboardingViewModel(private val onboardingUseCase: OnboardingUseCase) : BaseViewModel<Any, Nothing>(Any()) {

    private val mutableNavigation = OneTimeEvent<NavGraph.Levels>()
    val navigation: Flow<NavGraph.Levels>
        get() = mutableNavigation.receiveAsFlow()

    fun onStartClick() {
        scope.launch {
            runCatching {
                onboardingUseCase.setFirstLaunch()
            }.onSuccess {
                mutableNavigation.send(NavGraph.Levels)
            }.onFailure { throwable ->
                Napier.e(message = "Set first launch error", throwable = throwable)
                mutableNavigation.send(NavGraph.Levels)
            }
        }
    }
}
