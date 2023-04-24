package learn.git.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

@Composable
expect fun <C : Any, T : Any> Children(
    stack: Value<ChildStack<C, T>>,
    modifier: Modifier = Modifier,
    animation: StackAnimation<C, T>? = null,
    content: @Composable (child: Child.Created<C, T>) -> Unit,
)

@Composable
expect fun <C : Any, T : Any> Children(
    stack: ChildStack<C, T>,
    modifier: Modifier = Modifier,
    animation: StackAnimation<C, T>? = null,
    content: @Composable (child: Child.Created<C, T>) -> Unit,
)
