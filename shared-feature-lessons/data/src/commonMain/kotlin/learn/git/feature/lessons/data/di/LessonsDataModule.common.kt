package learn.git.feature.lessons.data.di

import learn.git.common.data.models.LocalLesson
import learn.git.core.utils.common.Mapper
import learn.git.feature.lessons.api.data.LessonsRepository
import learn.git.feature.lessons.api.domain.models.Lesson
import learn.git.feature.lessons.data.LessonsRepositoryImpl
import learn.git.feature.lessons.data.mappers.LessonMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module

val lessonsDataModule = module {

    factory<Mapper<LocalLesson, Lesson>>(named("LessonMapper")) {
        LessonMapper()
    }
    factory<LessonsRepository> {
        LessonsRepositoryImpl(
            lessonData = get(),
            lessonMapper = get(named("LessonMapper")),
        )
    }
}
