@file:Suppress("MissingModifierDefaultValue")

package learn.git.core.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.collections.immutable.PersistentSet
import kotlinx.collections.immutable.toPersistentSet

@Composable
actual fun <C : Any, T : Any> Children(
    stack: ChildStack<C, T>,
    modifier: Modifier,
    animation: StackAnimation<C, T>?,
    content: @Composable (child: Child.Created<C, T>) -> Unit,
) {
    val holder = rememberSaveableStateHolder()

    holder.retainStates(stack.getConfigurations().toPersistentSet())

    Box(modifier = modifier) {
        holder.SaveableStateProvider(stack.active.configuration.key()) {
            content(stack.active)
        }
    }
}

@Composable
actual fun <C : Any, T : Any> Children(
    stack: Value<ChildStack<C, T>>,
    modifier: Modifier,
    animation: StackAnimation<C, T>?,
    content: @Composable (child: Child.Created<C, T>) -> Unit,
) {
    val state = stack.subscribeAsState()

    Children(
        stack = state.value,
        modifier = modifier,
        animation = animation,
        content = content
    )
}

private fun ChildStack<*, *>.getConfigurations(): Set<String> =
    items.mapTo(HashSet()) { it.configuration.key() }

private fun Any.key(): String = "${this::class.simpleName}_${hashCode().toString(radix = 36)}"

@Suppress("ComposableFunctionName")
@Composable
private fun SaveableStateHolder.retainStates(currentKeys: PersistentSet<Any>) {
    val keys = remember(this) { Keys(currentKeys) }

    DisposableEffect(this, currentKeys) {
        keys.set.forEach {
            if (it !in currentKeys) {
                removeState(it)
            }
        }

        keys.set = currentKeys

        onDispose {}
    }
}

private class Keys(
    var set: Set<Any>
)
