package learn.git.feature.splash.domain

import learn.git.feature.splash.api.SplashRepository
import learn.git.feature.splash.api.SplashUseCase

internal class SplashUseCaseImpl(
    private val splashRepository: SplashRepository
) : SplashUseCase {

    override suspend fun isFirstLaunch(): Boolean = splashRepository.isFirstLaunch()
}
