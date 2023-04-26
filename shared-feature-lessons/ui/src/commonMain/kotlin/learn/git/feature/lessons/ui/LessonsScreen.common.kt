package learn.git.feature.lessons.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.pop
import learn.git.common.ui.utils.rememberBlock
import learn.git.common.ui.utils.rememberBlockWithParams
import learn.git.common.ui.utils.viewModel
import learn.git.core.navigation.NavGraph
import learn.git.core.navigation.Router
import learn.git.feature.lessons.presentation.LessonsViewModel
import learn.git.feature.lessons.ui.composable.LessonsAppBar
import learn.git.feature.lessons.ui.composable.LessonsList
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonsScreen(
    levelId: Long,
    router: Router<NavGraph>,
    modifier: Modifier = Modifier,
    viewModel: LessonsViewModel = viewModel { parametersOf(levelId) },
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            LessonsAppBar(
                onInfoClick = rememberBlock {},
                onNavigationClick = rememberBlock { router.pop() }
            )
        },
    ) { contentPadding ->
        LessonsList(
            state = state,
            contentPadding = contentPadding,
            onItemClick = rememberBlockWithParams { _ -> },
        )
    }
}
