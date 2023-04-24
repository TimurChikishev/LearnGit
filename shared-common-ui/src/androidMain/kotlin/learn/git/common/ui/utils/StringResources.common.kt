package learn.git.common.ui.utils

import dev.icerock.moko.resources.compose.stringResource as mokoStringResource
import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.StringResource

@Composable
actual fun stringResource(resource: StringResource): String = mokoStringResource(resource)

@Composable
actual fun stringResource(resource: StringResource, vararg args: Any): String = mokoStringResource(resource, args)
