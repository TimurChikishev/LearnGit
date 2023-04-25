package learn.git.common.ui.icons

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Challenge: ImageVector
    get() {
        if (challenge != null) {
            return challenge!!
        }
        challenge = Builder(
            name = "Challenge",
            defaultWidth = 224.0.dp,
            defaultHeight = 198.0.dp,
            viewportWidth = 224.0f,
            viewportHeight = 198.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(109.088f, 1.246f)
                curveTo(108.192f, 1.922f, 107.52f, 19.952f, 107.52f, 41.138f)
                verticalLineTo(79.677f)
                lineTo(87.36f, 99.961f)
                lineTo(67.2f, 120.02f)
                lineTo(56.0f, 108.976f)
                lineTo(44.8f, 97.707f)
                lineTo(21.952f, 120.921f)
                curveTo(3.808f, 139.177f, -0.448f, 144.36f, 1.792f, 146.614f)
                curveTo(4.032f, 148.868f, 8.736f, 145.262f, 24.64f, 129.26f)
                lineTo(44.8f, 108.976f)
                lineTo(53.088f, 117.541f)
                lineTo(61.6f, 125.879f)
                lineTo(30.688f, 156.981f)
                curveTo(9.632f, 178.167f, 0.0f, 189.436f, 0.0f, 193.042f)
                verticalLineTo(198.0f)
                horizontalLineTo(112.0f)
                horizontalLineTo(224.0f)
                verticalLineTo(193.042f)
                curveTo(224.0f, 189.436f, 214.368f, 178.167f, 193.312f, 156.981f)
                lineTo(162.4f, 125.879f)
                lineTo(170.912f, 117.541f)
                lineTo(179.2f, 108.976f)
                lineTo(199.36f, 129.26f)
                curveTo(215.264f, 145.262f, 219.968f, 148.868f, 222.208f, 146.614f)
                curveTo(224.448f, 144.36f, 220.192f, 139.177f, 202.048f, 120.921f)
                lineTo(179.2f, 97.707f)
                lineTo(168.0f, 108.976f)
                lineTo(156.8f, 120.02f)
                lineTo(136.64f, 99.961f)
                lineTo(116.256f, 79.677f)
                lineTo(116.928f, 60.52f)
                lineTo(117.6f, 41.589f)
                lineTo(137.312f, 33.7f)
                curveTo(148.512f, 29.193f, 156.8f, 24.685f, 156.8f, 22.882f)
                curveTo(156.8f, 21.079f, 147.168f, 15.219f, 135.296f, 9.811f)
                curveTo(112.672f, -0.782f, 111.328f, -1.233f, 109.088f, 1.246f)
                close()
                moveTo(137.536f, 112.131f)
                curveTo(160.16f, 134.895f, 161.504f, 136.923f, 157.248f, 139.177f)
                curveTo(150.528f, 142.783f, 147.84f, 142.332f, 138.432f, 135.796f)
                lineTo(129.92f, 129.711f)
                lineTo(120.96f, 136.021f)
                lineTo(112.0f, 142.332f)
                lineTo(103.04f, 136.021f)
                lineTo(94.08f, 129.711f)
                lineTo(85.568f, 135.796f)
                curveTo(75.936f, 142.332f, 73.472f, 142.783f, 67.2f, 138.951f)
                curveTo(62.944f, 136.247f, 64.288f, 134.444f, 86.688f, 111.906f)
                curveTo(99.904f, 98.383f, 111.328f, 87.565f, 112.0f, 87.565f)
                curveTo(112.672f, 87.565f, 124.096f, 98.609f, 137.536f, 112.131f)
                close()
            }
        }
            .build()
        return challenge!!
    }

private var challenge: ImageVector? = null
