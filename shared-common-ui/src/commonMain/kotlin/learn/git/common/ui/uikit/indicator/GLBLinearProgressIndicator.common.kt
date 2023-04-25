package learn.git.common.ui.uikit.indicator

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun GLBLinearProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
) {
    LinearProgressIndicator(
        modifier = modifier,
        progress = progress,
        color = color,
        trackColor = trackColor,
    )
}
