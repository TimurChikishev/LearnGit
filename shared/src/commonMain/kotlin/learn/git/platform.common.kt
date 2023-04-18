package learn.git

import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineDispatcher

expect fun Modifier.notchPadding(): Modifier

expect class PlatformStorableImage

expect fun createUUID(): String

expect val ioDispatcher: CoroutineDispatcher

expect val isShareFeatureSupported: Boolean

