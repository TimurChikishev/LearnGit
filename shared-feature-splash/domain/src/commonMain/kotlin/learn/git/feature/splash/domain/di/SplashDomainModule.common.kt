package learn.git.feature.splash.domain.di

import learn.git.feature.splash.api.SplashUseCase
import learn.git.feature.splash.domain.SplashUseCaseImpl
import org.koin.dsl.module

val splashDomainModule = module {
    factory<SplashUseCase> {
        SplashUseCaseImpl(splashRepository = get())
    }
}
