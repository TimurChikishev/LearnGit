package learn.git.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.DefaultComponentContext
import learn.git.common.ui.models.DeviceOrientation

@Composable
fun MainDesktop(defaultComponentContext: DefaultComponentContext) {
    MainCommon(
        platformDependencies = object : PlatformDependencies {

            override val componentContext: DefaultComponentContext = defaultComponentContext

            override val orientation: DeviceOrientation = DeviceOrientation.Portrait
        }
    )
}
