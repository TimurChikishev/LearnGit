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

val Icons.Branching: ImageVector
    get() {
        if (branching != null) {
            return branching!!
        }
        branching = Builder(
            name = "Branchig",
            defaultWidth = 139.0.dp,
            defaultHeight = 137.0.dp,
            viewportWidth = 139.0f,
            viewportHeight = 137.0f
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)),
                stroke = SolidColor(Color(0xFFffffff)),
                strokeLineWidth = 7.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(69.011f, 43.479f)
                verticalLineTo(61.351f)
            }
            path(
                fill = SolidColor(Color(0x00000000)),
                stroke = SolidColor(Color(0xFFffffff)),
                strokeLineWidth = 7.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(69.011f, 58.798f)
                curveTo(71.454f, 66.844f, 22.628f, 65.606f, 22.628f, 91.564f)
            }
            path(
                fill = SolidColor(Color(0x00000000)),
                stroke = SolidColor(Color(0xFFffffff)),
                strokeLineWidth = 7.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(69.1f, 58.798f)
                curveTo(66.639f, 66.949f, 115.819f, 65.695f, 115.819f, 91.989f)
            }
            path(
                fill = SolidColor(Color(0xFFffffff)),
                stroke = SolidColor(Color(0xFFffffff)),
                strokeLineWidth = 7.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(23.479f, 113.692f)
                moveToRelative(-19.479f, 0.0f)
                arcToRelative(
                    19.479f,
                    19.479f,
                    0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = 38.957f,
                    dy1 = 0.0f
                )
                arcToRelative(
                    19.479f,
                    19.479f,
                    0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = -38.957f,
                    dy1 = 0.0f
                )
            }
            path(
                fill = SolidColor(Color(0x00000000)),
                stroke = SolidColor(Color(0xFFffffff)),
                strokeLineWidth = 7.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(134.872f, 113.692f)
                curveTo(134.872f, 124.449f, 126.152f, 133.17f, 115.394f, 133.17f)
                curveTo(104.636f, 133.17f, 95.915f, 124.449f, 95.915f, 113.692f)
                curveTo(95.915f, 102.934f, 104.636f, 94.213f, 115.394f, 94.213f)
                curveTo(126.152f, 94.213f, 134.872f, 102.934f, 134.872f, 113.692f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFffffff)),
                stroke = SolidColor(Color(0xFFffffff)),
                strokeLineWidth = 7.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(69.436f, 23.479f)
                moveToRelative(-19.479f, 0.0f)
                arcToRelative(
                    19.479f,
                    19.479f,
                    0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = 38.957f,
                    dy1 = 0.0f
                )
                arcToRelative(
                    19.479f,
                    19.479f,
                    0.0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    dx1 = -38.957f,
                    dy1 = 0.0f
                )
            }
        }
            .build()
        return branching!!
    }

private var branching: ImageVector? = null
