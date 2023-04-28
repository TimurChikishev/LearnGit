package learn.git.feature.lessons.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import learn.git.common.ui.uikit.appbar.GLBCenterAlignedTopAppBar
import learn.git.common.ui.uikit.buttos.GLBIconButton
import learn.git.res.MR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LessonsAppBar(
    onInfoClick: () -> Unit,
    onNavigationClick: () -> Unit,
) {
    GLBCenterAlignedTopAppBar(
        title = MR.strings.lessons_appbar_title,
        onNavigationClick = onNavigationClick,
        actions = {
            GLBIconButton(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = Icons.Outlined.Info,
                onClick = onInfoClick,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.onBackground,
                )
            )
        }
    )
}
