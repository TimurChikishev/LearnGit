@file:Suppress("ModifierFactoryUnreferencedReceiver")

package learn.git.common.ui.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun TransparentSystemBars(darkIcons: Boolean) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = darkIcons,
            isNavigationBarContrastEnforced = false,
        )
    }
}

actual val statusBarInset: PaddingValues
    @Composable get() = WindowInsets.systemBars
        .only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal)
        .asPaddingValues()

actual val navigationBarInset: PaddingValues
    @Composable get() = WindowInsets.systemBars
        .only(WindowInsetsSides.Bottom + WindowInsetsSides.Horizontal)
        .asPaddingValues()

actual fun Modifier.navigationBarInset(): Modifier = navigationBarsPadding()

actual fun Modifier.statusBarInset(): Modifier = composed {
    windowInsetsPadding(
        WindowInsets.systemBars.only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal)
    )
}
