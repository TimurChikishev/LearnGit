package learn.git.feature.splash.api

interface SplashUseCase {

    suspend fun isFirstLaunch(): Boolean
}
