package learn.git.common.data.models

import dev.icerock.moko.resources.StringResource

data class LocalLesson(
    val id: Long,
    val title: StringResource,
    val subtitle: StringResource,
)
