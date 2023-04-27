package learn.git.feature.lessons.presentation.di

import learn.git.core.utils.common.Mapper
import learn.git.feature.lessons.api.domain.models.Lesson
import learn.git.feature.lessons.presentation.LessonsViewModel
import learn.git.feature.lessons.presentation.mappes.UiLessonMapper
import learn.git.feature.lessons.presentation.models.UiLesson
import org.koin.core.qualifier.named
import org.koin.dsl.module

val lessonsPresentationModule = module {
    factory<Mapper<Lesson, UiLesson>>(named("UiLessonMapper")) {
        UiLessonMapper()
    }
    factory { (levelId: Long) ->
        LessonsViewModel(
            levelId = levelId,
            lessonsUseCase = get(),
            lessonMapper = get(named("UiLessonMapper"))
        )
    }
}
