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
import platform.CoreGraphics.CGFloat
import platform.UIKit.UIApplication
import platform.UIKit.UIEdgeInsets

private val iosNotchInset = object : WindowInsets {
    override fun getTop(density: Density): Int =
        safeAreaInsets(density = density, direction = { top })

    override fun getBottom(density: Density): Int =
        safeAreaInsets(density = density, direction = { bottom })

    override fun getLeft(density: Density, layoutDirection: LayoutDirection): Int =
        safeAreaInsets(density = density, direction = { left })

    override fun getRight(density: Density, layoutDirection: LayoutDirection): Int =
        safeAreaInsets(density = density, direction = { right })

    fun safeAreaInsets(density: Density, direction: UIEdgeInsets.() -> CGFloat): Int {
        val safeAreaInsets = UIApplication.sharedApplication.keyWindow?.safeAreaInsets
        return if (safeAreaInsets != null) {
            val insets = safeAreaInsets.useContents { direction() }
            (insets * density.density).toInt()
        } else {
            0
        }
    }
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
