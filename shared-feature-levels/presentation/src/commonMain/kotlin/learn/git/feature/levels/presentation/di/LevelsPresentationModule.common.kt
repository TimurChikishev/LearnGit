package learn.git.feature.levels.presentation.di

import learn.git.feature.levels.presentation.LevelsViewModel
import org.koin.dsl.module

val levelsPresentationModule = module {
    factory {
        LevelsViewModel()
    }
}
