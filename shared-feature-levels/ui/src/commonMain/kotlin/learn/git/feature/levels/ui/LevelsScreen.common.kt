package learn.git.feature.levels.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.push
import learn.git.common.ui.utils.rememberBlock
import learn.git.common.ui.utils.rememberBlockWithParams
import learn.git.common.ui.utils.viewModel
import learn.git.core.navigation.NavGraph
import learn.git.core.navigation.Router
import learn.git.feature.levels.presentation.LevelsViewModel
import learn.git.feature.levels.ui.composable.LevelsAppBar
import learn.git.feature.levels.ui.composable.LevelsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LevelsScreen(
    router: Router<NavGraph>,
    modifier: Modifier = Modifier,
    viewModel: LevelsViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()
    Scaffold(
        modifier = modifier,
        topBar = {
            LevelsAppBar(
                onSettingsClick = rememberBlock { router.push(NavGraph.Settings) },
            )
        },
    ) { contentPadding ->
        LevelsList(
            state = state,
            contentPadding = contentPadding,
            onItemClick = rememberBlockWithParams { _ -> },
        )
    }
}
