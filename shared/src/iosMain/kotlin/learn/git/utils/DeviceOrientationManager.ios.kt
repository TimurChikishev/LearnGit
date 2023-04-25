package learn.git.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.ObjCAction
import learn.git.common.ui.models.DeviceOrientation
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSSelectorFromString
import platform.UIKit.UIApplication
import platform.UIKit.UIDeviceOrientationDidChangeNotification
import platform.darwin.NSObject

@ExportObjCClass
internal class DeviceOrientationManager(
    private val orientationDidChange: (DeviceOrientation) -> Unit,
) : NSObject() {

    fun registerDeviceOrientationManager() {
        NSNotificationCenter.defaultCenter.addObserver(
            observer = this,
            selector = NSSelectorFromString("orientationDidChange"),
            name = UIDeviceOrientationDidChangeNotification,
            `object` = null
        )
    }

    fun unregisterDeviceOrientationManager() = NSNotificationCenter.defaultCenter.removeObserver(this)

    @ObjCAction
    @Suppress("unused")
    private fun orientationDidChange() = orientationDidChange.invoke(currentDeviceOrientation)

    companion object {
        val currentDeviceOrientation: DeviceOrientation
            get() = when (UIApplication.sharedApplication.statusBarOrientation) {
                1L, 2L -> DeviceOrientation.Portrait
                3L, 4L -> DeviceOrientation.Landscape
                else -> DeviceOrientation.Undefined
            }
    }
}

@Composable
internal fun rememberDeviceOrientation(): DeviceOrientation {
    var orientation by remember { mutableStateOf(DeviceOrientationManager.currentDeviceOrientation) }
    val orientationManager = remember { DeviceOrientationManager { orientation = it } }

    DisposableEffect(true) {
        Napier.base(DebugAntilog())
        orientationManager.registerDeviceOrientationManager()

        onDispose {
            orientationManager.unregisterDeviceOrientationManager()
        }
    }

    return orientation
}
