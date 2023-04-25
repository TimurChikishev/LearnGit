package learn.git.feature.onboarding.presentation

import io.github.aakira.napier.Napier
import kotlinx.coroutines.launch
import learn.git.core.navigation.NavGraph
import learn.git.core.presentation.BaseViewModel
import learn.git.feature.onboarding.api.OnboardingUseCase
import learn.git.feature.onboarding.presentation.models.UiOnboardingLabel
import learn.git.feature.onboarding.presentation.models.UiOnboardingState

class OnboardingViewModel(
    private val onboardingUseCase: OnboardingUseCase
) : BaseViewModel<UiOnboardingState, UiOnboardingLabel>(UiOnboardingState()) {

    fun onNextPage(currentPage: Int) {
        val items = state.value.onboardingItems
        val nextPageIndex = currentPage + 1
        when {
            nextPageIndex <= items.lastIndex -> acceptLabel(UiOnboardingLabel.NextPage(nextPageIndex))
            else -> navigateToLevels()
        }
    }

    private fun navigateToLevels() {
        scope.launch {
            runCatching {
                onboardingUseCase.setFirstLaunch()
            }.onSuccess {
                mutableLabel.send(UiOnboardingLabel.Navigate(NavGraph.Levels))
            }.onFailure { throwable ->
                Napier.e(message = "Set first launch error", throwable = throwable)
                mutableLabel.send(UiOnboardingLabel.Navigate(NavGraph.Levels))
            }
        }
    }
}
