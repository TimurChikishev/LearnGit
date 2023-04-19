package learn.git.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.StackAnimation as DecomposeStackAnimation
actual fun interface StackAnimation<C : Any, T : Any> : DecomposeStackAnimation<C, T>