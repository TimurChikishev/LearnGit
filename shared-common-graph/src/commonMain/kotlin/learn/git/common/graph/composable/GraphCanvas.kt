package learn.git.common.graph.composable

import androidx.compose.foundation.Canvas
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.text.font.FontFamily
import learn.git.common.graph.tree.TreeNode
import learn.git.common.graph.tree.findMaxLevelSize
import learn.git.common.graph.walker.Walker

@Composable
internal fun GraphCanvas(
    tree: TreeNode<String>,
    walker: Walker<String>,
    shiftX: Float,
    shiftY: Float,
    nodeSize: Float,
    levelSeparation: Float,
    modifier: Modifier = Modifier,
    nodeColor: Color = MaterialTheme.colorScheme.onBackground,
    arrowColor: Color = MaterialTheme.colorScheme.onBackground,
    fontFamilyResolver: FontFamily.Resolver = LocalFontFamilyResolver.current,
) {
    Canvas(
        modifier = modifier
    ) {
        tree.setPosition(x = 0f, y = 0f)

        walker.positionTree(
            tree = tree,
            shiftX = shiftX + size.width / tree.findMaxLevelSize(),
            shiftY = shiftY + nodeSize / 2f
        )

        tree.forEach { node ->
            drawNode(
                node = node,
                nodeRadius = nodeSize / 2,
                contentColor = nodeColor,
                fontFamilyResolver = fontFamilyResolver
            )
            drawArrow(
                child = node,
                nodeSize = nodeSize,
                levelSeparation = levelSeparation,
                color = arrowColor
            )
        }
    }
}
