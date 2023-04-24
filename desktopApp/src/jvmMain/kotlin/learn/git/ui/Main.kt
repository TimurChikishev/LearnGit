package learn.git.ui

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import learn.git.di.initKoin
import learn.git.utils.getPreferredWindowSize
import learn.git.utils.runOnUiThread

fun main() = application {
    initKoin()

    val lifecycle = LifecycleRegistry()
    val defaultComponentContext = runOnUiThread {
        DefaultComponentContext(lifecycle = lifecycle)
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "LearnGit",
        state = WindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            size = getPreferredWindowSize(720, 857)
        ),
    ) {
        MainDesktop(
            targetDependencies = object : TargetDependencies {
                override val componentContext: DefaultComponentContext = defaultComponentContext
            }
        )
    }
}
