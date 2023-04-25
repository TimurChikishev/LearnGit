package learn.git.common.ui.utils

import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

@Composable
actual inline fun <reified T : ViewModel> viewModel(
    qualifier: Qualifier?,
    noinline parameters: ParametersDefinition?,
): T {
    return getViewModel(qualifier = qualifier, parameters = parameters)
}
