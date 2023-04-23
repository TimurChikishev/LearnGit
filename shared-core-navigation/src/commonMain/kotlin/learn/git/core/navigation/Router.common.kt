package learn.git.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.StackNavigationSource
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import kotlin.reflect.KClass
import kotlinx.collections.immutable.ImmutableList
import org.koin.ext.getFullName

val LocalRouter: ProvidableCompositionLocal<Router<*>?> =
    staticCompositionLocalOf { null }

val LocalComponentContext: ProvidableCompositionLocal<ComponentContext> =
    staticCompositionLocalOf { error("Root component context was not provided") }

class Router<C : Parcelable>(
    private val navigator: StackNavigation<C>,
    val stack: State<ChildStack<C, ComponentContext>>,
) : StackNavigation<C> by navigator

@Composable
private fun <C : Parcelable> rememberChildStack(
    source: StackNavigationSource<C>,
    initialStack: () -> List<C>,
    clazz: KClass<C>,
    key: String = clazz.getFullName(),
    handleBackButton: Boolean = false,
): State<ChildStack<C, ComponentContext>> {
    val componentContext = LocalComponentContext.current

    return remember {
        componentContext.childStack(
            source = source,
            clazz = clazz,
            initialStack = initialStack,
            key = key,
            handleBackButton = handleBackButton,
            childFactory = { _, childComponentContext -> childComponentContext },
        )
    }.subscribeAsState()
}

private fun <C : Parcelable, T : Any> ComponentContext.childStack(
    source: StackNavigationSource<C>,
    initialStack: () -> List<C>,
    clazz: KClass<C>,
    key: String = "DefaultChildStack",
    persistent: Boolean = true,
    handleBackButton: Boolean = false,
    childFactory: (configuration: C, ComponentContext) -> T
): Value<ChildStack<C, T>> =
    childStack(
        source = source,
        initialStack = initialStack,
        configurationClass = clazz,
        key = key,
        persistent = persistent,
        handleBackButton = handleBackButton,
        childFactory = childFactory,
    )

@Composable
fun <C : Parcelable> rememberRouter(
    stack: ImmutableList<C>,
    clazz: KClass<C>,
    handleBackButton: Boolean = true
): Router<C> {
    val navigator: StackNavigation<C> = remember { StackNavigation() }

    val childStackState: State<ChildStack<C, ComponentContext>> = rememberChildStack(
        source = navigator,
        initialStack = { stack },
        clazz = clazz,
        handleBackButton = handleBackButton
    )

    return remember { Router(navigator = navigator, stack = childStackState) }
}

@Composable
@Suppress("ReusedModifierInstance")
fun <C : Parcelable> NavigationContent(
    router: Router<C>,
    modifier: Modifier = Modifier,
    animation: StackAnimation<C, ComponentContext>? = null,
    content: @Composable (C) -> Unit,
) {
    CompositionLocalProvider(LocalRouter provides router) {
        Children(
            stack = router.stack.value,
            modifier = modifier,
            animation = animation,
        ) { child ->
            CompositionLocalProvider(LocalComponentContext provides child.instance) {
                content(child.configuration)
            }
        }
    }
}

@Composable
fun <T : Any> Value<T>.subscribeAsState(): State<T> {
    val state = remember(this) { mutableStateOf(value) }

    DisposableEffect(this) {
        val observer: (T) -> Unit = { state.value = it }

        subscribe(observer)

        onDispose {
            unsubscribe(observer)
        }
    }

    return state
}
