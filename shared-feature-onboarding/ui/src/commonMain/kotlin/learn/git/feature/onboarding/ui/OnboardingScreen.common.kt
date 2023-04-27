package learn.git.feature.onboarding.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.router.stack.replaceCurrent
import learn.git.common.ui.theme.paddingSize48
import learn.git.common.ui.utils.get
import learn.git.common.ui.utils.navigationBarInset
import learn.git.common.ui.utils.rememberBlock
import learn.git.common.ui.utils.statusBarInset
import learn.git.core.navigation.NavGraph
import learn.git.core.navigation.Router
import learn.git.feature.onboarding.presentation.OnboardingViewModel
import learn.git.feature.onboarding.presentation.models.UiOnboardingLabel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    router: Router<NavGraph>,
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel = get(),
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()

    Column(modifier = modifier) {
        OnboardingHorizontalPager(
            modifier = Modifier
                .weight(1f)
                .statusBarInset(),
            pagerState = pagerState,
            onboardingItems = state.onboardingItems,
        )
        OnboardingBottomBar(
            modifier = Modifier
                .background(Color.Transparent)
                .navigationBarInset()
                .fillMaxWidth()
                .padding(bottom = paddingSize48)
                .padding(horizontal = paddingSize48),
            pagerState = pagerState,
            pageCount = state.onboardingItems.size,
            onNextPage = rememberBlock { viewModel.onNextPage(pagerState.currentPage) },
        )
    }

    LaunchedEffect(true) {
        viewModel.label.collect { label ->
            when (label) {
                is UiOnboardingLabel.Navigate -> router.replaceCurrent(label.destination)
                is UiOnboardingLabel.NextPage -> pagerState.animateScrollToPage(label.index)
            }
        }
    }
}
