@file:Suppress("MissingModifierDefaultValue")

package learn.git.core.navigation

import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children as DecomposeChildren
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

@Composable
actual fun <C : Any, T : Any> Children(
    stack: Value<ChildStack<C, T>>,
    modifier: Modifier,
    animation: StackAnimation<C, T>?,
    content: @Composable (child: Child.Created<C, T>) -> Unit
) {
    DecomposeChildren(
        stack = stack,
        modifier = modifier,
        animation = animation ?: stackAnimation(fade().plus(scale())),
        content = content
    )
}

@Composable
actual fun <C : Any, T : Any> Children(
    stack: ChildStack<C, T>,
    modifier: Modifier,
    animation: StackAnimation<C, T>?,
    content: @Composable (child: Child.Created<C, T>) -> Unit,
) {
    DecomposeChildren(
        stack = stack,
        modifier = modifier,
        animation = animation ?: stackAnimation(fade().plus(scale())),
        content = content,
    )
}
