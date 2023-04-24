package learn.git.common.ui.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Modifier

expect val statusBarInset: PaddingValues

expect val navigationBarInset: PaddingValues

expect fun Modifier.statusBarInset(): Modifier

expect fun Modifier.navigationBarInset(): Modifier