package learn.git.core.navigation

import androidx.compose.foundation.layout.Box

internal fun <C : Any, T : Any> emptyStackAnimation(): StackAnimation<C, T> =
    StackAnimation { stack, modifier, childContent ->
        Box(modifier = modifier) {
            childContent(stack.active)
        }
    }

