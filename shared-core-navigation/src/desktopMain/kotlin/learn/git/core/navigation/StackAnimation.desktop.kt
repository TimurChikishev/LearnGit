package learn.git.core.navigation

import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.StackAnimation as DecomposeStackAnimation

actual fun interface StackAnimation<C : Any, T : Any> : DecomposeStackAnimation<C, T>
