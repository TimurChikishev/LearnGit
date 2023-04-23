package learn.git.common.ui.icons.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import learn.git.common.ui.icons.Icons

val Icons.Outline.Branching: ImageVector
    get() {
        if (branching != null) {
            return branching!!
        }
        branching = Builder(name = "Group 82", defaultWidth = 257.0.dp, defaultHeight = 257.0.dp,
            viewportWidth = 257.0f, viewportHeight = 257.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 7.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(129.045f, 70.219f)
                moveToRelative(-25.913f, 0.0f)
                arcToRelative(25.913f, 25.913f, 0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = 51.826f,
                    dy1 = 0.0f
                )
                arcToRelative(25.913f, 25.913f, 0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = -51.826f,
                    dy1 = 0.0f
                )
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 7.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(187.87f, 185.692f)
                moveToRelative(-25.913f, 0.0f)
                arcToRelative(25.913f, 25.913f, 0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = 51.826f,
                    dy1 = 0.0f
                )
                arcToRelative(25.913f, 25.913f, 0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = -51.826f,
                    dy1 = 0.0f
                )
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 7.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(70.219f, 185.692f)
                moveToRelative(-25.913f, 0.0f)
                arcToRelative(25.913f, 25.913f, 0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = 51.826f,
                    dy1 = 0.0f
                )
                arcToRelative(25.913f, 25.913f, 0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = -51.826f,
                    dy1 = 0.0f
                )
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 7.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(128.5f, 95.82f)
                verticalLineToRelative(22.876f)
                moveToRelative(0.0f, -3.268f)
                curveToRelative(3.127f, 10.299f, -59.37f, 8.715f, -59.37f, 41.94f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 7.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(128.614f, 115.428f)
                curveToRelative(-3.15f, 10.433f, 59.801f, 8.828f, 59.801f, 42.485f)
            }
        }
            .build()

        return branching!!
    }

private var branching: ImageVector? = null
