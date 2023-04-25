package learn.git.di

import learn.git.common.ui.di.themeModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(koinPlatformModules())
        modules(
            themeModule,
            *storageModules,
            *onboardingModules,
            *splashModules,
            *levelsModules,
        )
    }
}

expect fun koinPlatformModules(): List<Module>
