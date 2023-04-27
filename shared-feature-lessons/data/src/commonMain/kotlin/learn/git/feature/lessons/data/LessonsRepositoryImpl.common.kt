package learn.git.feature.lessons.data

import learn.git.common.data.LessonData
import learn.git.common.data.models.LocalLesson
import learn.git.core.utils.common.Mapper
import learn.git.feature.lessons.api.data.LessonsRepository
import learn.git.feature.lessons.api.domain.models.Lesson

internal class LessonsRepositoryImpl(
    private val lessonData: LessonData,
    private val lessonMapper: Mapper<LocalLesson, Lesson>
) : LessonsRepository {

    override fun getLessons(levelId: Long): List<Lesson> = lessonData.getLessons(levelId).map(lessonMapper::map)
}
