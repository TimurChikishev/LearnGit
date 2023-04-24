package learn.git.feature.onboarding.presentation.models

import learn.git.core.navigation.NavGraph

sealed interface UiOnboardingLabel {

    data class NextPage(val index: Int) : UiOnboardingLabel

    data class Navigate(val destination: NavGraph) : UiOnboardingLabel
}
