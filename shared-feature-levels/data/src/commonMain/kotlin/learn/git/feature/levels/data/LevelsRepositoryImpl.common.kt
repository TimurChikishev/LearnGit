package learn.git.feature.levels.data

import learn.git.common.data.LevelData
import learn.git.common.data.models.LocalLevel
import learn.git.core.utils.common.Mapper
import learn.git.feature.levels.api.data.LevelsRepository
import learn.git.feature.levels.api.domain.models.Level

internal class LevelsRepositoryImpl(
    private val levelsData: LevelData,
    private val levelsMapper: Mapper<LocalLevel, Level>
) : LevelsRepository {

    override fun getAllLevels(): List<Level> = levelsData.getAllLessons().map(levelsMapper::map)
}
