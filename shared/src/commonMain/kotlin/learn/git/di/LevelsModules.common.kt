package learn.git.di

import learn.git.feature.levels.data.di.levelsDataModule
import learn.git.feature.levels.domain.di.levelsDomainModule
import learn.git.feature.levels.presentation.di.levelsPresentationModule
import org.koin.core.module.Module

internal val levelsModules: Array<Module> = arrayOf(
    levelsDataModule,
    levelsDomainModule,
    levelsPresentationModule,
)
