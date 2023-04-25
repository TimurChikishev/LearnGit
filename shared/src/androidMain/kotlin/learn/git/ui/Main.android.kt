package learn.git.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.DefaultComponentContext
import learn.git.common.ui.models.DeviceOrientation
import learn.git.utils.deviceOrientation

@Composable
fun MainAndroid(defaultComponentContext: DefaultComponentContext) {
    MainCommon(
        platformDependencies = object : PlatformDependencies {

            override val componentContext: DefaultComponentContext = defaultComponentContext

            override val orientation: DeviceOrientation = deviceOrientation
        }
    )
}
