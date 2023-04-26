package learn.git.feature.lessons.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import learn.git.common.ui.theme.paddingSize12
import learn.git.common.ui.theme.paddingSize8
import learn.git.common.ui.utils.defaultBorder
import learn.git.feature.lessons.presentation.models.UiLesson

@Composable
internal fun LessonItem(
    item: UiLesson,
    position: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(paddingSize12),
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .defaultBorder()
                .padding(paddingSize8),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = position.toString(),
                style = MaterialTheme.typography.labelLarge,
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(paddingSize8),
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.labelLarge,
            )
            Text(
                text = item.subtitle,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}
