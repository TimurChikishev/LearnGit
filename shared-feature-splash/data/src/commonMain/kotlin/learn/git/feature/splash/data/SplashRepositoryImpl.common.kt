package learn.git.feature.splash.data

import learn.git.core.storage.data.settings.SettingsStorage
import learn.git.feature.splash.api.SplashRepository

internal class SplashRepositoryImpl(
    private val settingsStorage: SettingsStorage
) : SplashRepository {
    override suspend fun isFirstLaunch(): Boolean = settingsStorage.isFirstLaunch()
}
