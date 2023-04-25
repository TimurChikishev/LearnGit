package learn.git.common.ui.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalLayoutDirection

expect val statusBarInset: PaddingValues

expect val navigationBarInset: PaddingValues

expect fun Modifier.statusBarInset(): Modifier

expect fun Modifier.navigationBarInset(): Modifier

fun Modifier.navigationBarHorizontalPadding(): Modifier = composed {
    padding(
        start = navigationBarInset.calculateLeftPadding(LocalLayoutDirection.current),
        end = navigationBarInset.calculateRightPadding(LocalLayoutDirection.current),
    )
}
