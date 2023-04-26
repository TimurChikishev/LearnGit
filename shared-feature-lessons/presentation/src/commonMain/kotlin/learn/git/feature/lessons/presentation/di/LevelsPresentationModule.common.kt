package learn.git.feature.lessons.presentation.di

import learn.git.feature.lessons.presentation.LessonsViewModel
import org.koin.dsl.module

val lessonsPresentationModule = module {
    factory { (levelId: Long) ->
        LessonsViewModel(
            levelId = levelId,
        )
    }
}
