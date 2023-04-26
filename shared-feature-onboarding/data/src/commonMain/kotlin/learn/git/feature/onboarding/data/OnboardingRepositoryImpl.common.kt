package learn.git.feature.onboarding.data

import learn.git.core.storage.preference.settings.SettingsStorage
import learn.git.feature.onboarding.api.OnboardingRepository

class OnboardingRepositoryImpl(
    private val settingsStorage: SettingsStorage
) : OnboardingRepository {

    override suspend fun setFirstLaunch() = settingsStorage.setFirstLaunch()
}
