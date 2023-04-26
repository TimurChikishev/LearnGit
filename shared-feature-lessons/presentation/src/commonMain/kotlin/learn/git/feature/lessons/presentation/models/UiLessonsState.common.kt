package learn.git.feature.lessons.presentation.models

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class UiLessonsState(
    val lessons: PersistentList<UiLesson> = persistentListOf()
)
