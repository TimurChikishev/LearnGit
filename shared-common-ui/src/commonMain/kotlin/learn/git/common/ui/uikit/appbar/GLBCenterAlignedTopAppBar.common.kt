package learn.git.common.ui.uikit.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButtonDefaults
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
        navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
        actionIconContentColor = MaterialTheme.colorScheme.onBackground,
    ),
    actions: @Composable() (RowScope.() -> Unit) = {},
    onNavigationClick: () -> Unit = {},
) {
    GLBCenterAlignedTopAppBar(
        modifier = modifier,
        title = stringResource(title),
        showNavigationIcon = showNavigationIcon,
        onNavigationClick = onNavigationClick,
        textStyle = textStyle,
        colors = colors,
        actions = actions,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GLBCenterAlignedTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    showNavigationIcon: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Color.Transparent,
        navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
        actionIconContentColor = MaterialTheme.colorScheme.onBackground,
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
                text = title,
                style = textStyle,
            )
        },
        navigationIcon = {
            if (showNavigationIcon) {
                GLBIconButton(
                    imageVector = Icons.Default.ArrowBack,
                    onClick = onNavigationClick,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                    ),
                )
            }
        },
        actions = actions,
        colors = colors,
    )
}
