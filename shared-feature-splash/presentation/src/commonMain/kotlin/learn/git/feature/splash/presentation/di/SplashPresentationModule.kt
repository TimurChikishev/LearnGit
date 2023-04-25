package learn.git.feature.splash.presentation.di

import learn.git.feature.splash.presentation.SplashViewModel
import org.koin.dsl.module

val splashPresentationModule = module {
    factory {
        SplashViewModel(
            splashUseCase = get()
        )
    }
}
