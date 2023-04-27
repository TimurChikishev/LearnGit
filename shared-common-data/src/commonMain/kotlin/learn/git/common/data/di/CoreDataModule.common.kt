package learn.git.common.data.di

import learn.git.common.data.LessonData
import learn.git.common.data.LessonDataImpl
import learn.git.common.data.LevelData
import learn.git.common.data.LevelDataImpl
import org.koin.dsl.module

val coreDataModule = module {
    factory<LevelData> {
        LevelDataImpl()
    }
    factory<LessonData> {
        LessonDataImpl()
    }
}
