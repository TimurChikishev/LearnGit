package learn.git.feature.onboarding.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import learn.git.common.ui.uikit.buttos.GLBIconButton
import learn.git.common.ui.uikit.pager.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun OnboardingBottomBar(
    pagerState: PagerState,
    pageCount: Int,
    onNextPage: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        HorizontalPagerIndicator(
            pagerState = pagerState,
            pageCount = pageCount,
        )
        GLBIconButton(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            imageVector = Icons.Default.ArrowForward,
            onClick = onNextPage,
        )
    }
}
