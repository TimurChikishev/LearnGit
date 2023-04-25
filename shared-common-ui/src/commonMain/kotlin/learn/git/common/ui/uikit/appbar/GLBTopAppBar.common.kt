package learn.git.common.ui.uikit.appbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import dev.icerock.moko.resources.StringResource
import learn.git.common.ui.uikit.buttos.GLBIconButton
import learn.git.common.ui.utils.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GLBAppBar(
    title: StringResource,
    modifier: Modifier = Modifier,
    showNavigationIcon: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    actions: @Composable() (RowScope.() -> Unit) = {},
    onNavigationClick: () -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
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
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                    ),
                )
            }
        },
        actions = actions,
    )
}
