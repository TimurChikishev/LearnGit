package learn.git.feature.levels.presentation.models

import dev.icerock.moko.resources.StringResource

data class UiLevel(
    val id: Long,
    val title: StringResource,
    val subtitle: StringResource,
    val progress: Float,
)
