package learn.git.feature.onboarding.domain.id

import learn.git.feature.onboarding.api.OnboardingUseCase
import learn.git.feature.onboarding.domain.OnboardingUseCaseImpl
import org.koin.dsl.module

val onboardingDomainModule = module {
    factory<OnboardingUseCase> {
        OnboardingUseCaseImpl(repository = get())
    }
}
