package learn.git.common.graph.composable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import learn.git.common.graph.tree.TreeNode

private val linePath = Path()
private val trianglePath = Path()

internal fun <T> DrawScope.drawArrow(
    child: TreeNode<T>,
    nodeSize: Float,
    halfWidth: Float = 10f,
    levelSeparation: Float,
    color: Color
) {
    val parent = child.parent ?: return
    val nodeRadius = nodeSize / 2f

    drawLinePath(
        child = child,
        parent = parent,
        nodeRadius = nodeRadius,
        levelSeparation = levelSeparation,
        color = color
    )
    drawTrianglePath(
        parent = parent,
        halfWidth = halfWidth,
        nodeRadius = nodeRadius,
        color = color
    )
}

private fun <T> DrawScope.drawLinePath(
    child: TreeNode<T>,
    parent: TreeNode<T>,
    nodeRadius: Float,
    levelSeparation: Float,
    color: Color
) {
    linePath.apply {
        reset()
        // position at the middle-top of the child
        moveTo(
            x = child.position.x,
            y = child.position.y - nodeRadius
        )
        // draws a line from the child's middle-top halfway up to its parent
        lineTo(
            x = child.position.x,
            y = child.position.y - nodeRadius - (levelSeparation / 2)
        )
        // draws a line from the previous point to the middle of the parents width
        lineTo(
            x = parent.position.x,
            y = child.position.y - nodeRadius - (levelSeparation / 2)
        )
        // position at the middle of the level separation under the parent
        moveTo(
            x = parent.position.x,
            y = child.position.y - nodeRadius - (levelSeparation / 2)
        )
        // draws a line-up to the parents middle-bottom
        lineTo(
            x = parent.position.x,
            y = parent.position.y + nodeRadius
        )
    }
    drawPath(
        path = linePath,
        color = color,
        style = Stroke(
            width = 2.dp.toPx(),
            join = StrokeJoin.Round,
            pathEffect = PathEffect.cornerPathEffect(25f),
        )
    )
}

private fun <T> DrawScope.drawTrianglePath(
    parent: TreeNode<T>,
    nodeRadius: Float,
    halfWidth: Float,
    color: Color
) {
    trianglePath.apply {
        reset()
        // Top center
        moveTo(
            x = parent.position.x,
            y = parent.position.y + nodeRadius
        )
        // Bottom left
        lineTo(
            x = parent.position.x - halfWidth,
            y = parent.position.y + nodeRadius + halfWidth
        )
        // Bottom right
        lineTo(
            x = parent.position.x + halfWidth,
            y = parent.position.y + nodeRadius + halfWidth
        )
        // Back to Top Center
        lineTo(
            x = parent.position.x,
            y = parent.position.y + nodeRadius
        )
    }
    drawPath(
        path = trianglePath,
        color = color
    )
}
