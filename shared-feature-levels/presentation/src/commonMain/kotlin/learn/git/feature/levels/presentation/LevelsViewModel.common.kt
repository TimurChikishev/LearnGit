package learn.git.feature.levels.presentation

import kotlinx.collections.immutable.toPersistentList
import learn.git.core.presentation.BaseViewModel
import learn.git.core.utils.common.Mapper
import learn.git.feature.levels.api.domain.LevelsUseCase
import learn.git.feature.levels.api.domain.models.Level
import learn.git.feature.levels.presentation.models.UiLevel
import learn.git.feature.levels.presentation.models.UiLevelsState

class LevelsViewModel(
    private val levelsUseCase: LevelsUseCase,
    private val levelsMapper: Mapper<Level, UiLevel>,
) : BaseViewModel<UiLevelsState, Nothing>(initialState = UiLevelsState()) {

    init {
        init()
    }

    private fun init() {
        val levels = levelsUseCase
            .getAllLevels()
            .map(levelsMapper::map)
            .toPersistentList()

        mutableState.value = UiLevelsState(levels = levels)
    }
}
