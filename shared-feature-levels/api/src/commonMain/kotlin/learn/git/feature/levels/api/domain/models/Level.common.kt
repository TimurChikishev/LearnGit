package learn.git.feature.levels.api.domain.models

import dev.icerock.moko.resources.StringResource

data class Level(
    val id: Long,
    val title: StringResource,
    val subtitle: StringResource,
)
