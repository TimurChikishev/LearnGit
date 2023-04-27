package learn.git.feature.lessons.presentation

import kotlinx.collections.immutable.toPersistentList
import learn.git.core.presentation.BaseViewModel
import learn.git.core.utils.common.Mapper
import learn.git.feature.lessons.api.domain.LessonsUseCase
import learn.git.feature.lessons.api.domain.models.Lesson
import learn.git.feature.lessons.presentation.models.UiLesson
import learn.git.feature.lessons.presentation.models.UiLessonsState

class LessonsViewModel(
    private val levelId: Long,
    private val lessonsUseCase: LessonsUseCase,
    private val lessonMapper: Mapper<Lesson, UiLesson>,
) : BaseViewModel<UiLessonsState, Nothing>(UiLessonsState()) {

    init {
        init()
    }

    private fun init() {
        val lessons = lessonsUseCase.getLessons(levelId)
            .map(lessonMapper::map)
            .toPersistentList()

        mutableState.value = UiLessonsState(
            lessons = lessons,
        )
    }
}
