package learn.git.feature.levels.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import learn.git.common.ui.uikit.appbar.GLBCenterAlignedTopAppBar
import learn.git.common.ui.uikit.buttos.GLBIconButton
import learn.git.res.MR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LevelsAppBar(
    onSettingsClick: () -> Unit
) {
    GLBCenterAlignedTopAppBar(
        title = MR.strings.levels_appbar_title,
        showNavigationIcon = false,
        actions = {
            GLBIconButton(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = Icons.Outlined.Settings,
                onClick = onSettingsClick,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground,
                )
            )
        }
    )
}
