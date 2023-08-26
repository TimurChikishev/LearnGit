package learn.git.common.graph.composable

import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.text.font.FontFamily
import learn.git.common.graph.tree.TreeNode
import learn.git.common.graph.walker.Walker
import learn.git.common.graph.walker.WalkerConfig

private val treeNode = TreeNode("0").apply {
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

private val defaultWalkerConfig = WalkerConfig(
    siblingSeparation = 70F,
    levelSeparation = 70F,
    subtreeSeparation = 50F,
    nodeSize = 70F,
)

@Composable
fun Graph(
    tree: TreeNode<String>,
    modifier: Modifier = Modifier,
    walkerConfig: WalkerConfig = defaultWalkerConfig,
    nodeColor: Color = MaterialTheme.colorScheme.onBackground,
    arrowColor: Color = MaterialTheme.colorScheme.onBackground,
    fontFamilyResolver: FontFamily.Resolver = LocalFontFamilyResolver.current,
) {
    var shiftX by remember { mutableStateOf(0f) }
    var shiftY by remember { mutableStateOf(0f) }
    var zoomScale by remember { mutableStateOf(1f) }

    val config by remember(zoomScale) {
        mutableStateOf(
            walkerConfig.copy(
                siblingSeparation = walkerConfig.siblingSeparation * zoomScale,
                levelSeparation = walkerConfig.levelSeparation * zoomScale,
                subtreeSeparation = walkerConfig.subtreeSeparation * zoomScale,
                nodeSize = walkerConfig.nodeSize * zoomScale
            )
        )
    }

    val walker = remember(config) { Walker<String>(config = config) }

    GraphCanvas(
        modifier = modifier.fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    shiftX += pan.x
                    shiftY += pan.y
                    zoomScale *= zoom
                }
            },
        tree = tree,
        walker = walker,
        shiftY = shiftY,
        shiftX = shiftX,
        nodeSize = config.nodeSize,
        levelSeparation = config.levelSeparation,
        nodeColor = nodeColor,
        arrowColor = arrowColor,
        fontFamilyResolver = fontFamilyResolver,
    )
}
