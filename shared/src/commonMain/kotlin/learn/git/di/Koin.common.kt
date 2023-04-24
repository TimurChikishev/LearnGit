package learn.git.di

import learn.git.common.ui.di.themeModule
import learn.git.core.storage.di.platformStorageModule
import learn.git.core.storage.di.storageModule
import learn.git.feature.splash.data.di.splashDataModule
import learn.git.feature.splash.domain.di.splashDomainModule
import learn.git.feature.splash.presentation.di.splashPresentationModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(koinPlatformModules())
        modules(
            themeModule,

            platformStorageModule,
            storageModule,

            splashDataModule,
            splashDomainModule,
            splashPresentationModule,
        )
    }
}

expect fun koinPlatformModules(): List<Module>
