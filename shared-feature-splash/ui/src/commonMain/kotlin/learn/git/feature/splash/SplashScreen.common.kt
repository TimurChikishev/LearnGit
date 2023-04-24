package learn.git.feature.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.replaceCurrent
import kotlinx.coroutines.delay
import learn.git.common.ui.icons.Icons
import learn.git.common.ui.icons.outline.Branching
import learn.git.core.navigation.NavGraph
import learn.git.core.navigation.Router

@Composable
fun SplashScreen(
    router: Router<NavGraph>,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Outline.Branching,
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = null
        )
    }
    LaunchedEffect(true) {
        delay(1000)
        router.replaceCurrent(NavGraph.Onboarding)
    }
}
