package learn.git.feature.lessons.presentation.models

import dev.icerock.moko.resources.StringResource

data class UiLesson(
    val id: Long,
    val title: StringResource,
    val subtitle: StringResource,
)
