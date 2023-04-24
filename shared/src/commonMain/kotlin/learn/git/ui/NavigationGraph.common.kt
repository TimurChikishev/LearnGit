package learn.git.ui

import androidx.compose.runtime.Composable
import kotlinx.collections.immutable.persistentListOf
import learn.git.core.navigation.NavGraph
import learn.git.core.navigation.NavigationContent
import learn.git.core.navigation.rememberRouter
import learn.git.feature.onboarding.ui.OnboardingScreen
import learn.git.feature.splash.ui.SplashScreen

@Composable
internal fun NavigationGraph() {
    val router = rememberRouter(
        stack = persistentListOf(NavGraph.Splash),
        clazz = NavGraph::class,
    )

    NavigationContent(
        router = router,
    ) { screen ->
        when (screen) {
            is NavGraph.Splash -> SplashScreen(router = router)
            is NavGraph.Onboarding -> OnboardingScreen(router = router)
            is NavGraph.Levels -> {}
        }
    }
}
