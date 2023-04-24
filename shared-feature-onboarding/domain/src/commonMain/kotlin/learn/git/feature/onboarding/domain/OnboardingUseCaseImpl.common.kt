package learn.git.feature.onboarding.domain

import learn.git.feature.onboarding.api.OnboardingRepository
import learn.git.feature.onboarding.api.OnboardingUseCase

class OnboardingUseCaseImpl(
    private val repository: OnboardingRepository
) : OnboardingUseCase {

    override suspend fun setFirstLaunch() = repository.setFirstLaunch()
}
