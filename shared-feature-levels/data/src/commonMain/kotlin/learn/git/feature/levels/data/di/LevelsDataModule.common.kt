package learn.git.feature.levels.data.di

import learn.git.common.data.models.LocalLevel
import learn.git.core.utils.common.Mapper
import learn.git.feature.levels.api.data.LevelsRepository
import learn.git.feature.levels.api.domain.models.Level
import learn.git.feature.levels.data.LevelsRepositoryImpl
import learn.git.feature.levels.data.mapper.LevelsMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module

val levelsDataModule = module {
    factory<Mapper<LocalLevel, Level>>(named("LevelsMapper")) {
        LevelsMapper()
    }
    factory<LevelsRepository> {
        LevelsRepositoryImpl(
            levelsData = get(),
            levelsMapper = get(named("LevelsMapper"))
        )
    }
}
