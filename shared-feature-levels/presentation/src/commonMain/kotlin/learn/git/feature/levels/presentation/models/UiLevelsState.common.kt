package learn.git.feature.levels.presentation.models

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class UiLevelsState(
    val levels: PersistentList<UiLevel> = persistentListOf()
)
