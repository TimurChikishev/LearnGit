package learn.git.feature.lessons.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import learn.git.common.ui.theme.paddingSize16
import learn.git.common.ui.utils.defaultBorder
import learn.git.common.ui.utils.navigationBarHorizontalPadding
import learn.git.common.ui.utils.navigationBarInset
import learn.git.feature.lessons.presentation.models.UiLessonsState

@Composable
internal fun LessonsList(
    state: UiLessonsState,
    contentPadding: PaddingValues,
    onItemClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            top = contentPadding.calculateTopPadding(),
            bottom = navigationBarInset.calculateBottomPadding(),
            start = paddingSize16,
            end = paddingSize16,
        ),
        verticalArrangement = Arrangement.spacedBy(paddingSize16),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        itemsIndexed(
            items = state.lessons,
            key = { _, item -> item.id }
        ) { index, item ->
            LessonItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarHorizontalPadding()
                    .defaultBorder()
                    .clip(MaterialTheme.shapes.medium)
                    .clickable(onClick = { onItemClick(item.id) })
                    .padding(paddingSize16),
                item = item,
                position = index.plus(1),
            )
        }
    }
}
