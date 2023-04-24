package learn.git.feature.onboarding.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.arkivanov.decompose.router.stack.replaceCurrent
import learn.git.common.ui.icons.Icons
import learn.git.common.ui.icons.outline.Branching
import learn.git.common.ui.theme.fontSize16
import learn.git.common.ui.theme.fontSize32
import learn.git.common.ui.theme.paddingSize16
import learn.git.common.ui.theme.paddingSize48
import learn.git.common.ui.uikit.buttos.GLBButton
import learn.git.common.ui.utils.navigationBarInset
import learn.git.common.ui.utils.rememberBlock
import learn.git.common.ui.utils.statusBarInset
import learn.git.common.ui.utils.stringResource
import learn.git.core.navigation.NavGraph
import learn.git.core.navigation.Router
import learn.git.res.MR

@Composable
fun OnboardingScreen(
    router: Router<NavGraph>,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .statusBarInset()
            .navigationBarInset(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(horizontal = paddingSize16),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.padding(top = paddingSize16),
                imageVector = Icons.Outline.Branching,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = null
            )
            Text(
                text = stringResource(MR.strings.onboarding_welcome_title),
                fontWeight = FontWeight.Bold,
                fontSize = fontSize32,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                modifier = Modifier.padding(top = paddingSize16),
                text = stringResource(MR.strings.onboarding_welcome_subtitle),
                fontWeight = FontWeight.Normal,
                fontSize = fontSize16,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(modifier = Modifier.weight(1f))
            GLBButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = paddingSize48),
                textAllCaps = true,
                textStyle = LocalTextStyle.current.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary,
                ),
                stringResource = MR.strings.onboarding_start_button_text,
                onClick = rememberBlock { router.replaceCurrent(NavGraph.Levels) },
            )
        }
    }
}
