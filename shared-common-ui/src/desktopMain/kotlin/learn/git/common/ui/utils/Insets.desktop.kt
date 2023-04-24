package learn.git.common.ui.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Modifier

actual val statusBarInset: PaddingValues
    get() = PaddingValues()

actual val navigationBarInset: PaddingValues
    get() = PaddingValues()

actual fun Modifier.statusBarInset(): Modifier = this

actual fun Modifier.navigationBarInset(): Modifier = this
