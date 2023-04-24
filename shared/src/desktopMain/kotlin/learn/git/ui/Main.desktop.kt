package learn.git.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ApplicationScope

@Composable
fun ApplicationScope.MainDesktop(targetDependencies: TargetDependencies) {
    MainCommon(targetDependencies = targetDependencies)
}
