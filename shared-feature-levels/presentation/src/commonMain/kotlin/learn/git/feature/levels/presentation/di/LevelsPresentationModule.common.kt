package learn.git.feature.levels.presentation.di

import learn.git.core.utils.common.Mapper
import learn.git.feature.levels.api.domain.models.Level
import learn.git.feature.levels.presentation.LevelsViewModel
import learn.git.feature.levels.presentation.mappers.UiLevelsMapper
import learn.git.feature.levels.presentation.models.UiLevel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val levelsPresentationModule = module {
    factory<Mapper<Level, UiLevel>>(named("UiLevelsMapper")) {
        UiLevelsMapper()
    }
    factory {
        LevelsViewModel(
            levelsUseCase = get(),
            levelsMapper = get(named("UiLevelsMapper")),
        )
    }
}
