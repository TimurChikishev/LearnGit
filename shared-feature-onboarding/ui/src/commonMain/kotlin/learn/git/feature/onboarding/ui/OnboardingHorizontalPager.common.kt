package learn.git.feature.onboarding.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.PersistentList
import learn.git.feature.onboarding.presentation.models.OnboardingItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun OnboardingHorizontalPager(
    pagerState: PagerState,
    onboardingItems: PersistentList<OnboardingItem>,
    modifier: Modifier = Modifier,
) {
    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        pageCount = onboardingItems.size,
    ) { index ->
        OnboardingPage(
            pageItem = onboardingItems[index],
        )
    }
}
