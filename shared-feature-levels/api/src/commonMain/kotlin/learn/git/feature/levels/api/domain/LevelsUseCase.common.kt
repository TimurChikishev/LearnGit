package learn.git.feature.levels.api.domain

import learn.git.feature.levels.api.domain.models.Level

interface LevelsUseCase {

    fun getAllLevels(): List<Level>
}
