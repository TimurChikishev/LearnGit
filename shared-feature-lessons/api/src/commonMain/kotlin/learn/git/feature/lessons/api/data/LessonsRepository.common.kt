package learn.git.feature.lessons.api.data

import learn.git.feature.lessons.api.domain.models.Lesson

interface LessonsRepository {

    fun getLessons(levelId: Long): List<Lesson>
}
