package learn.git.common.ui.utils

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import learn.git.common.ui.models.DeviceOrientation

val LocalDeviceOrientation: ProvidableCompositionLocal<DeviceOrientation> =
    staticCompositionLocalOf { error("Local device orientation was not provided") }
