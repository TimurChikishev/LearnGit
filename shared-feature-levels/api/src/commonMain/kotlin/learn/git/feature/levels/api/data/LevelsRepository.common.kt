package learn.git.feature.levels.api.data

import learn.git.feature.levels.api.domain.models.Level

interface LevelsRepository {

    fun getAllLevels(): List<Level>
}
