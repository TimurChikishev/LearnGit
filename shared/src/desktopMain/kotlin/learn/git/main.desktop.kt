package learn.git

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import java.awt.Dimension
import java.awt.Toolkit

@Composable
fun ApplicationScope.ImageViewerDesktop() {
    val ioScope = rememberCoroutineScope { ioDispatcher }
//    val toastState = remember { mutableStateOf<ToastState>(ToastState.Hidden) }
//    val externalNavigationEventBus = remember { ExternalNavigationEventBus() }
//    val dependencies = remember {
//        getDependencies(toastState, ioScope, externalNavigationEventBus.events)
//    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "Image Viewer",
        state = WindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            size = getPreferredWindowSize(720, 857)
        ),
    ) {
//        ImageViewerTheme {
//            Surface(
//                modifier = Modifier.fillMaxSize()
//            ) {
//                ImageViewerCommon(
//                    dependencies = dependencies
//                )
//                Toast(toastState)
//            }
//        }
    }
}

private fun getPreferredWindowSize(desiredWidth: Int, desiredHeight: Int): DpSize {
    val screenSize: Dimension = Toolkit.getDefaultToolkit().screenSize
    val preferredWidth: Int = (screenSize.width * 0.8f).toInt()
    val preferredHeight: Int = (screenSize.height * 0.8f).toInt()
    val width: Int = if (desiredWidth < preferredWidth) desiredWidth else preferredWidth
    val height: Int = if (desiredHeight < preferredHeight) desiredHeight else preferredHeight
    return DpSize(width.dp, height.dp)
}
