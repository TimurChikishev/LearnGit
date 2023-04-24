package learn.git.feature.splash.api

interface SplashRepository {

    suspend fun isFirstLaunch(): Boolean
}
