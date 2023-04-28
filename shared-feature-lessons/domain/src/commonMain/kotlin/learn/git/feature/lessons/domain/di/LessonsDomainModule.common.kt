package learn.git.feature.lessons.domain.di

import learn.git.feature.lessons.api.domain.LessonsUseCase
import learn.git.feature.lessons.domain.LessonsUseCaseImpl
import org.koin.dsl.module

val lessonsDomainModule = module {
    factory<LessonsUseCase> {
        LessonsUseCaseImpl(
            lessonsRepository = get(),
        )
    }
}
