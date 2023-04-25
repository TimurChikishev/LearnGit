package learn.git.common.ui.uikit.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import dev.icerock.moko.resources.StringResource
import learn.git.common.ui.uikit.buttos.GLBIconButton
import learn.git.common.ui.utils.statusBarInset
import learn.git.common.ui.utils.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GLBCenterAlignedTopAppBar(
    title: StringResource,
    modifier: Modifier = Modifier,
    showNavigationIcon: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Color.Transparent,
    ),
    actions: @Composable() (RowScope.() -> Unit) = {},
    onNavigationClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.4f to MaterialTheme.colorScheme.background,
                        0.8f to MaterialTheme.colorScheme.background.copy(alpha = 0.8f),
                        1f to Color.Transparent,
                    ),
                ),
            )
            .statusBarInset(),
        title = {
            Text(
                text = stringResource(title),
                style = textStyle,
            )
        },
        navigationIcon = {
            if (showNavigationIcon) {
                GLBIconButton(
                    imageVector = Icons.Default.ArrowBack,
                    onClick = onNavigationClick,
                )
            }
        },
        actions = actions,
        colors = colors,
    )
}
