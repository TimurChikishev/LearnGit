package learn.git.di

import learn.git.feature.lessons.data.di.lessonsDataModule
import learn.git.feature.lessons.domain.di.lessonsDomainModule
import learn.git.feature.lessons.presentation.di.lessonsPresentationModule
import org.koin.core.module.Module

internal val lessonsModules: Array<Module> = arrayOf(
    lessonsDataModule,
    lessonsDomainModule,
    lessonsPresentationModule,
)
