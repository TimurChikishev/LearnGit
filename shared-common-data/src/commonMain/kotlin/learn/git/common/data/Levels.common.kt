package learn.git.common.data

import learn.git.common.data.models.LocalLevel
import learn.git.res.MR

interface LevelData {

    fun getAllLessons(): List<LocalLevel>
}

internal class LevelDataImpl : LevelData {

    override fun getAllLessons(): List<LocalLevel> = levels
}

internal object Level {
    const val INTRODUCTION = 1L
}

internal val levels: List<LocalLevel> = listOf(
    LocalLevel(
        id = Level.INTRODUCTION,
        title = MR.strings.level_introduction_title,
        subtitle = MR.strings.level_introduction_subtitle,
    )
)
