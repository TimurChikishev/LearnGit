package learn.git.feature.levels.presentation

import kotlinx.collections.immutable.persistentListOf
import learn.git.core.presentation.BaseViewModel
import learn.git.feature.levels.presentation.models.UiLevel
import learn.git.feature.levels.presentation.models.UiLevelsState

class LevelsViewModel : BaseViewModel<UiLevelsState, Nothing>(initialState = UiLevelsState()) {

    init {
        mutableState.value = UiLevelsState(
            levels = persistentListOf(
                UiLevel(
                    id = 1,
                    title = "Introduction",
                    subtitle = "A well-chosen introduction to the basic git commands",
                    progress = 0.5F,
                ),
            ),
        )
    }
}
