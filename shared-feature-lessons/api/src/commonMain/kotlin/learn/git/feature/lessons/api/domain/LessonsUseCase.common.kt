package learn.git.feature.lessons.api.domain

import learn.git.feature.lessons.api.domain.models.Lesson

interface LessonsUseCase {

    fun getLessons(levelId: Long): List<Lesson>
}
