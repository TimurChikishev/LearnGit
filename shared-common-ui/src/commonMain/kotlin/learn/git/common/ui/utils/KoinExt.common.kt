package learn.git.common.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.mp.KoinPlatformTools

fun getKoinContext() = KoinPlatformTools.defaultContext().get()

@Composable
inline fun <reified T> get(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null,
): T = remember(qualifier, parameters) {

    getKoinContext().get(qualifier = qualifier, parameters = parameters)
}

@Composable
expect inline fun <reified T : ViewModel> viewModel(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null,
): T
