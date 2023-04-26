package learn.git.feature.lessons.presentation

import kotlinx.collections.immutable.persistentListOf
import learn.git.core.presentation.BaseViewModel
import learn.git.feature.lessons.presentation.models.UiLesson
import learn.git.feature.lessons.presentation.models.UiLessonsState

class LessonsViewModel(
    private val levelId: Long
) : BaseViewModel<UiLessonsState, Nothing>(UiLessonsState()) {

    init {
        mutableState.value = UiLessonsState(
            lessons = persistentListOf(
                UiLesson(
                    id = 1,
                    title = "Introduction to commit",
                    subtitle = "Learning how to take a snapshot of current changes in a project",
                ),
                UiLesson(
                    id = 2,
                    title = "Introduction to branching",
                    subtitle = "Learning how to create new branches in a project",
                ),
                UiLesson(
                    id = 3,
                    title = "Introduction to merge",
                    subtitle = "Learning how to merge one branch into another",
                ),
                UiLesson(
                    id = 4,
                    title = "Introduction to rebase",
                    subtitle = "Learning how to merge one branch into another using rebase",
                ),
            ),
        )
    }
}
