package learn.git.feature.lessons.data.mappers

import learn.git.common.data.models.LocalLesson
import learn.git.core.utils.common.Mapper
import learn.git.feature.lessons.api.domain.models.Lesson

internal class LessonMapper : Mapper<LocalLesson, Lesson> {

    override fun map(item: LocalLesson): Lesson = with(item) {
        Lesson(
            id = id,
            title = title,
            subtitle = subtitle,
        )
    }
}
