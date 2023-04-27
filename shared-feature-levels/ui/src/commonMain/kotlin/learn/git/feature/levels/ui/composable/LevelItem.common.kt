package learn.git.feature.levels.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import learn.git.common.ui.theme.paddingSize8
import learn.git.common.ui.uikit.indicator.GLBLinearProgressIndicator
import learn.git.common.ui.utils.stringResource
import learn.git.feature.levels.presentation.models.UiLevel

@Composable
internal fun LevelItem(
    item: UiLevel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(paddingSize8),
    ) {
        Text(
            text = stringResource(item.title),
            style = MaterialTheme.typography.labelLarge,
        )
        Text(
            text = stringResource(item.subtitle),
            style = MaterialTheme.typography.bodySmall,
        )
        GLBLinearProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingSize8),
            progress = item.progress,
        )
    }
}
