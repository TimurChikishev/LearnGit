package learn.git.feature.lessons.domain

import learn.git.feature.lessons.api.data.LessonsRepository
import learn.git.feature.lessons.api.domain.LessonsUseCase
import learn.git.feature.lessons.api.domain.models.Lesson

internal class LessonsUseCaseImpl(
    private val lessonsRepository: LessonsRepository,
) : LessonsUseCase {

    override fun getLessons(levelId: Long): List<Lesson> = lessonsRepository.getLessons(levelId)
}
