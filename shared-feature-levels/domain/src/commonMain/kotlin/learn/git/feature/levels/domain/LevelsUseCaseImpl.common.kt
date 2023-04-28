package learn.git.feature.levels.domain

import learn.git.feature.levels.api.data.LevelsRepository
import learn.git.feature.levels.api.domain.LevelsUseCase
import learn.git.feature.levels.api.domain.models.Level

internal class LevelsUseCaseImpl(
    private val levelsRepository: LevelsRepository
) : LevelsUseCase {

    override fun getAllLevels(): List<Level> = levelsRepository.getAllLevels()
}
