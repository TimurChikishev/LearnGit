package learn.git.feature.onboarding.presentation.models

import androidx.compose.material.icons.Icons
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import learn.git.common.res.icons.Branching
import learn.git.common.res.icons.Challenge
import learn.git.common.res.icons.Guide
import learn.git.res.MR

data class UiOnboardingState(
    val onboardingItems: PersistentList<OnboardingItem> = defaultOnboardingItems,
) {
    companion object {
        private val defaultOnboardingItems = persistentListOf(
            OnboardingItem(
                title = MR.strings.onboarding_welcome_title,
                subtitle = MR.strings.onboarding_welcome_subtitle,
                image = Icons.Branching,
            ),
            OnboardingItem(
                title = MR.strings.onboarding_guide_title,
                subtitle = MR.strings.onboarding_guide_subtitle,
                image = Icons.Guide,
            ),
            OnboardingItem(
                title = MR.strings.onboarding_challenge_title,
                subtitle = MR.strings.onboarding_challenge_subtitle,
                image = Icons.Challenge,
            ),
        )
    }
}
