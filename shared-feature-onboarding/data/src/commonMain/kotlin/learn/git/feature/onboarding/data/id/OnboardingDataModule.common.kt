package learn.git.feature.onboarding.data.id

import learn.git.feature.onboarding.api.OnboardingRepository
import learn.git.feature.onboarding.data.OnboardingRepositoryImpl
import org.koin.dsl.module

val onboardingDataModule = module {
    factory<OnboardingRepository> {
        OnboardingRepositoryImpl(settingsStorage = get())
    }
}
