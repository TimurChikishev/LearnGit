package learn.git.feature.levels.presentation.mappers

import learn.git.core.utils.common.Mapper
import learn.git.feature.levels.api.domain.models.Level
import learn.git.feature.levels.presentation.models.UiLevel

internal class UiLevelsMapper : Mapper<Level, UiLevel> {
    override fun map(item: Level): UiLevel = with(item) {
        UiLevel(
            id = id,
            title = title,
            subtitle = subtitle,
            progress = 0f,
        )
    }
}
