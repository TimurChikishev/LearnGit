package learn.git.common.data

import learn.git.common.data.models.LocalLesson
import learn.git.res.MR

interface LessonData {

    fun getLessons(levelId: Long): List<LocalLesson>
}

internal class LessonDataImpl : LessonData {
    override fun getLessons(levelId: Long): List<LocalLesson> = lessons.getValue(levelId)
}

internal val lessons: Map<Long, List<LocalLesson>> = mapOf(
    Level.INTRODUCTION to listOf(
        LocalLesson(
            id = 1,
            levelId = Level.INTRODUCTION,
            title = MR.strings.lesson_introduction_to_commit_title,
            subtitle = MR.strings.lesson_introduction_to_commit_subtitle,
        ),
        LocalLesson(
            id = 2,
            levelId = Level.INTRODUCTION,
            title = MR.strings.lesson_introduction_to_branching_title,
            subtitle = MR.strings.lesson_introduction_to_branching_subtitle,
        ),
        LocalLesson(
            id = 3,
            levelId = Level.INTRODUCTION,
            title = MR.strings.lesson_introduction_to_merge_title,
            subtitle = MR.strings.lesson_introduction_to_merge_subtitle,
        ),
        LocalLesson(
            id = 4,
            levelId = Level.INTRODUCTION,
            title = MR.strings.lesson_introduction_to_rebase_title,
            subtitle = MR.strings.lesson_introduction_to_rebase_subtitle,
        ),
    ),
)
