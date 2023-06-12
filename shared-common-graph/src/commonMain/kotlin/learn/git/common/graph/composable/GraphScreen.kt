package learn.git.common.graph.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFontFamilyResolver
import learn.git.common.graph.tree.TreeNode
import learn.git.common.graph.tree.findMaxLevelSize
import learn.git.common.graph.walker.Walker
import learn.git.common.graph.walker.WalkerConfig

private val tree = TreeNode("0").apply {
    addChild(
        TreeNode("C1").apply {
            addChild(TreeNode("C7"))
            addChild(TreeNode("C8"))
        }
    )
    addChild(
        TreeNode("C2").apply {
            addChild(TreeNode("C3"))
            addChild(
                TreeNode("C4").apply {
                    addChild(TreeNode("C5"))
                    addChild(TreeNode("C6"))
                }
            )
            addChild(TreeNode("C12"))
        }
    )
    addChild(
        TreeNode("C9").apply {
            addChild(TreeNode("C10"))
            addChild(TreeNode("C11"))
        }
    )
}

@Suppress("ModifierMissing")
@Composable
fun GraphScreen() {
    val nodeColor = MaterialTheme.colorScheme.onBackground
    val arrowColor = MaterialTheme.colorScheme.onBackground

    var shiftX by remember { mutableStateOf(0f) }
    var shiftY by remember { mutableStateOf(0f) }
    var zoomScale by remember { mutableStateOf(1f) }

    val fontFamilyResolver = LocalFontFamilyResolver.current

    val config by remember(zoomScale) {
        mutableStateOf(
            WalkerConfig(
                siblingSeparation = 70 * zoomScale.toInt(),
                levelSeparation = 70 * zoomScale.toInt(),
                subtreeSeparation = 50 * zoomScale.toInt(),
                nodeSize = 70 * zoomScale.toInt()
            )
        )
    }

    val walker = remember(config) {
        Walker<String>(
            config = config
        )
    }

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { centroid, pan, zoom, rotation ->
                    shiftX += pan.x
                    shiftY += pan.y
                    zoomScale *= zoom
                }
            }
    ) {
        val nodeSize = config.nodeSize.toFloat()
        val levelSeparation = config.levelSeparation.toFloat()

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
