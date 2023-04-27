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
            title = MR.strings.lesson_introduction_to_commit_title,
            subtitle = MR.strings.lesson_introduction_to_commit_subtitle,
        ),
        LocalLesson(
            id = 2,
            title = MR.strings.lesson_introduction_to_branching_title,
            subtitle = MR.strings.lesson_introduction_to_branching_subtitle,
        ),
        LocalLesson(
            id = 3,
            title = MR.strings.lesson_introduction_to_merge_title,
            subtitle = MR.strings.lesson_introduction_to_merge_subtitle,
        ),
        LocalLesson(
            id = 4,
            title = MR.strings.lesson_introduction_to_rebase_title,
            subtitle = MR.strings.lesson_introduction_to_rebase_subtitle,
        ),
    ),
    Level.INTERMEDIATE to listOf(
        LocalLesson(
            id = 5,
            title = MR.strings.lesson_intermediate_to_cherry_pick_title,
            subtitle = MR.strings.lesson_intermediate_to_cherry_pick_subtitle,
        ),
        LocalLesson(
            id = 6,
            title = MR.strings.lesson_intermediate_to_interactive_rebase_title,
            subtitle = MR.strings.lesson_intermediate_to_interactive_rebase_subtitle,
        ),
    ),
)
