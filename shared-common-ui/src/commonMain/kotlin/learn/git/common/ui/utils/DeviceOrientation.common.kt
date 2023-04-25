package learn.git.common.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import learn.git.common.ui.models.DeviceOrientation

@Composable
fun OrientationWrapper(
    portrait: @Composable () -> Unit,
    landscape: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        when (LocalDeviceOrientation.current) {
            is DeviceOrientation.Portrait -> portrait()
            is DeviceOrientation.Landscape -> landscape()
            is DeviceOrientation.Undefined -> Unit
        }
    }
}
