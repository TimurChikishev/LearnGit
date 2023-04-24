package learn.git.feature.onboarding.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import learn.git.common.ui.theme.paddingSize16
import learn.git.common.ui.utils.stringResource
import learn.git.feature.onboarding.presentation.models.OnboardingItem

private val iconSize = DpSize(width = 200.dp, height = 200.dp)

@Composable
internal fun OnboardingPage(
    pageItem: OnboardingItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier
                .fillMaxWidth()
                .size(iconSize)
                .padding(vertical = paddingSize16),
            imageVector = pageItem.image,
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = null,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(pageItem.title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = paddingSize16),
            text = stringResource(pageItem.subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}
