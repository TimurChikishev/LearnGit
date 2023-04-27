package learn.git.feature.levels.data.mapper

import learn.git.common.data.models.LocalLevel
import learn.git.core.utils.common.Mapper
import learn.git.feature.levels.api.domain.models.Level

internal class LevelsMapper : Mapper<LocalLevel, Level> {
    override fun map(item: LocalLevel): Level = with(item) {
        Level(
            id = id,
            title = title,
            subtitle = subtitle,
        )
    }
}
