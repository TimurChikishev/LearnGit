package learn.git.common.ui.utils

import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import learn.git.common.ui.theme.defaultBorderStroke

fun Modifier.defaultBorder(): Modifier = composed {
    border(
        border = defaultBorderStroke,
        shape = MaterialTheme.shapes.medium,
    )
}
