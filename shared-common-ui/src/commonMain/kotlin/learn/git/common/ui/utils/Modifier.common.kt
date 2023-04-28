package learn.git.common.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import learn.git.common.ui.theme.defaultBorderStroke

fun Modifier.defaultBorder(): Modifier = composed {
    border(
        border = defaultBorderStroke,
        shape = MaterialTheme.shapes.medium,
    )
}

fun Modifier.verticalGradientBackground(): Modifier = composed {
    background(
        brush = Brush.verticalGradient(
            colorStops = arrayOf(
                0.4f to MaterialTheme.colorScheme.background,
                0.8f to MaterialTheme.colorScheme.background.copy(alpha = 0.8f),
                1f to Color.Transparent,
            ),
        ),
    )
}
