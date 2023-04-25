package learn.git.feature.settings.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.pop
import learn.git.common.ui.uikit.appbar.GLBCenterAlignedTopAppBar
import learn.git.common.ui.utils.rememberBlock
import learn.git.core.navigation.NavGraph
import learn.git.core.navigation.Router
import learn.git.res.MR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    router: Router<NavGraph>,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            GLBCenterAlignedTopAppBar(
                title = MR.strings.settings_appbar_title,
                onNavigationClick = rememberBlock { router.pop() }
            )
        }
    ) { contentPadding ->
    }
}
