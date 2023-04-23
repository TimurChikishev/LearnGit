package learn.git.common.ui.utils

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.StringResource

@Composable
expect fun stringResource(resource: StringResource): String

@Composable
expect fun stringResource(resource: StringResource, vararg args: Any): String
