package learn.git.common.ui.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlinx.cinterop.useContents
import platform.UIKit.UIApplication

private val iosNotchInset = object : WindowInsets {
    override fun getTop(density: Density): Int {
        val safeAreaInsets = UIApplication.sharedApplication.keyWindow?.safeAreaInsets
        return if (safeAreaInsets != null) {
            val topInset = safeAreaInsets.useContents { this.top }
            (topInset * density.density).toInt()
        } else {
            0
        }
    }

    override fun getBottom(density: Density): Int {
        val safeAreaInsets = UIApplication.sharedApplication.keyWindow?.safeAreaInsets
        return if (safeAreaInsets != null) {
            val bottomInset = safeAreaInsets.useContents { this.bottom }
            (bottomInset * density.density).toInt()
        } else {
            0
        }
    }

    override fun getLeft(density: Density, layoutDirection: LayoutDirection): Int = 0
    override fun getRight(density: Density, layoutDirection: LayoutDirection): Int = 0
}

actual val statusBarInset: PaddingValues
    @Composable get() = iosNotchInset.asPaddingValues()

actual fun Modifier.statusBarInset(): Modifier = windowInsetsPadding(
    iosNotchInset.only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal)
)

actual fun Modifier.navigationBarInset(): Modifier = this

actual val navigationBarInset: PaddingValues
    @Composable get() = iosNotchInset
        .only(WindowInsetsSides.Bottom + WindowInsetsSides.Horizontal)
        .asPaddingValues()
