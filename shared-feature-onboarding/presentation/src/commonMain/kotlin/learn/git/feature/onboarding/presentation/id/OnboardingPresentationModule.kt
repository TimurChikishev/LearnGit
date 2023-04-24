package learn.git.feature.onboarding.presentation.id

import learn.git.feature.onboarding.presentation.OnboardingViewModel
import org.koin.dsl.module

val onboardingPresentationModule = module {
    factory {
        OnboardingViewModel(onboardingUseCase = get())
    }
}
