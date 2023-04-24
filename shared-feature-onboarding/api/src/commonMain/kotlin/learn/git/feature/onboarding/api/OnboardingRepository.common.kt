package learn.git.feature.onboarding.api

interface OnboardingRepository {

    suspend fun setFirstLaunch()
}
