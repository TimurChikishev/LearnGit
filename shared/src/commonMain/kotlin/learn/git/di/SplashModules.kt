package learn.git.di

import learn.git.feature.splash.data.di.splashDataModule
import learn.git.feature.splash.domain.di.splashDomainModule
import learn.git.feature.splash.presentation.di.splashPresentationModule
import org.koin.core.module.Module

internal val splashModules: Array<Module> = arrayOf(
    splashDataModule,
    splashDomainModule,
    splashPresentationModule,
)
