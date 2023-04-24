package learn.git.feature.splash.data.di

import learn.git.feature.splash.api.SplashRepository
import learn.git.feature.splash.data.SplashRepositoryImpl
import org.koin.dsl.module

val splashDataModule = module {
    factory<SplashRepository> {
        SplashRepositoryImpl(settingsStorage = get())
    }
}
