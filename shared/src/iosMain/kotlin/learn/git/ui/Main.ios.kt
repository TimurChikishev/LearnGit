package learn.git.ui

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import learn.git.common.ui.models.DeviceOrientation
import learn.git.utils.rememberDeviceOrientation
import platform.UIKit.UIViewController

@Suppress("FunctionName", "unused")
fun MainViewController(defaultComponentContext: DefaultComponentContext): UIViewController =
    ComposeUIViewController {

        val orientation = rememberDeviceOrientation()

        MainCommon(
            platformDependencies = object : PlatformDependencies {

                override val componentContext: DefaultComponentContext = defaultComponentContext

                override val orientation: DeviceOrientation = orientation
            }
        )
    }
