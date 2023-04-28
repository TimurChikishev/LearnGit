package learn.git.feature.lessons.presentation.mappes

import learn.git.core.utils.common.Mapper
import learn.git.feature.lessons.api.domain.models.Lesson
import learn.git.feature.lessons.presentation.models.UiLesson

internal class UiLessonMapper : Mapper<Lesson, UiLesson> {

    override fun map(item: Lesson): UiLesson = with(item) {
        UiLesson(
            id = id,
            title = title,
            subtitle = subtitle
        )
    }
}
