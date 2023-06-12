package learn.git.common.graph.composable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawTransform
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import learn.git.common.graph.tree.TreeNode

@OptIn(ExperimentalTextApi::class)
internal fun DrawScope.drawNode(
    node: TreeNode<String>,
    nodeRadius: Float,
    contentColor: Color,
    borderColor: Color = contentColor,
    fontFamilyResolver: FontFamily.Resolver,
) {
    drawCircle(
        color = contentColor,
        center = Offset(x = node.position.x, y = node.position.y),
        radius = nodeRadius
    )
    drawCircle(
        color = borderColor,
        center = Offset(x = node.position.x, y = node.position.y),
        radius = nodeRadius,
        style = Stroke(width = 4f)
    )
    drawIntoCanvas {
        val text = node.value

        val textMeasurer = TextMeasurer(
            fallbackFontFamilyResolver = fontFamilyResolver,
            fallbackDensity = Density(0f, 0f),
            fallbackLayoutDirection = layoutDirection
        )

        val textLayoutResult = textMeasurer.measure(
            text = AnnotatedString(text),
            style = TextStyle(
                color = Color.Black,
                fontSize = nodeRadius.toSp()
            ),
            layoutDirection = layoutDirection,
            density = this
        )

        val textWidth = textLayoutResult.multiParagraph.width
        val textHeight = textLayoutResult.multiParagraph.height

        val xOffset = node.position.x - (textWidth / 2f)
        val yOffset = node.position.y - (textHeight / 2f)

        val topLeft = Offset(xOffset, yOffset)

        withTransform({
            translate(topLeft.x, topLeft.y)
            clip(textLayoutResult)
        }) {
            textLayoutResult.multiParagraph.paint(
                canvas = drawContext.canvas,
                blendMode = DrawScope.DefaultBlendMode
            )
        }
    }
}

private fun DrawTransform.clip(textLayoutResult: TextLayoutResult) {
    if (textLayoutResult.hasVisualOverflow &&
        textLayoutResult.layoutInput.overflow != TextOverflow.Visible
    ) {
        clipRect(
            left = 0f,
            top = 0f,
            right = textLayoutResult.size.width.toFloat(),
            bottom = textLayoutResult.size.height.toFloat()
        )
    }
}
