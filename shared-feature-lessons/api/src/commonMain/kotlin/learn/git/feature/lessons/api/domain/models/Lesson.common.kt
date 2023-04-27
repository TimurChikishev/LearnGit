package learn.git.feature.lessons.api.domain.models

import dev.icerock.moko.resources.StringResource

data class Lesson(
    val id: Long,
    val title: StringResource,
    val subtitle: StringResource,
)
