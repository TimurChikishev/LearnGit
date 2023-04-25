package learn.git.di

import learn.git.feature.levels.presentation.di.levelsPresentationModule
import org.koin.core.module.Module

internal val levelsModules: Array<Module> = arrayOf(
    levelsPresentationModule,
)
