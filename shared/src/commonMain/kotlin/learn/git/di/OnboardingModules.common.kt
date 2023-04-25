package learn.git.di

import learn.git.feature.onboarding.data.id.onboardingDataModule
import learn.git.feature.onboarding.domain.id.onboardingDomainModule
import learn.git.feature.onboarding.presentation.id.onboardingPresentationModule
import org.koin.core.module.Module

internal val onboardingModules: Array<Module> = arrayOf(
    onboardingDataModule,
    onboardingDomainModule,
    onboardingPresentationModule,
)
