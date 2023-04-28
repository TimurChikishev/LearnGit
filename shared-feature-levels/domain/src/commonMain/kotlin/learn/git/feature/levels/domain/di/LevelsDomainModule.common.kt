package learn.git.feature.levels.domain.di

import learn.git.feature.levels.api.domain.LevelsUseCase
import learn.git.feature.levels.domain.LevelsUseCaseImpl
import org.koin.dsl.module

val levelsDomainModule = module {
    factory<LevelsUseCase> {
        LevelsUseCaseImpl(
            levelsRepository = get()
        )
    }
}
