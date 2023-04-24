package learn.git.feature.onboarding.presentation.models

import androidx.compose.ui.graphics.vector.ImageVector
import dev.icerock.moko.resources.StringResource

data class OnboardingItem(
    val title: StringResource,
    val subtitle: StringResource,
    val image: ImageVector,
)
