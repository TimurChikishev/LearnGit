package learn.git.common.res.icons

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

val Icons.Guide: ImageVector
    get() {
        if (guide != null) {
            return guide!!
        }
        guide = Builder(
            name = "Guid",
            defaultWidth = 224.0.dp,
            defaultHeight = 164.0.dp,
            viewportWidth = 224.0f,
            viewportHeight = 164.0f
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
                moveTo(132.364f, 57.912f)
                verticalLineTo(45.612f)
                curveTo(137.964f, 43.221f, 143.691f, 41.427f, 149.545f, 40.231f)
                curveTo(155.4f, 39.035f, 161.552f, 38.438f, 168.0f, 38.438f)
                curveTo(172.412f, 38.438f, 176.739f, 38.779f, 180.982f, 39.463f)
                curveTo(185.224f, 40.146f, 189.382f, 41.0f, 193.455f, 42.025f)
                verticalLineTo(53.3f)
                curveTo(189.382f, 51.763f, 185.267f, 50.609f, 181.109f, 49.841f)
                curveTo(176.952f, 49.072f, 172.582f, 48.688f, 168.0f, 48.688f)
                curveTo(161.552f, 48.688f, 155.358f, 49.499f, 149.418f, 51.122f)
                curveTo(143.479f, 52.745f, 137.794f, 55.008f, 132.364f, 57.912f)
                close()
                moveTo(132.364f, 114.287f)
                verticalLineTo(101.731f)
                curveTo(137.964f, 99.425f, 143.691f, 97.695f, 149.545f, 96.542f)
                curveTo(155.4f, 95.389f, 161.552f, 94.813f, 168.0f, 94.813f)
                curveTo(172.412f, 94.813f, 176.739f, 95.154f, 180.982f, 95.838f)
                curveTo(185.224f, 96.521f, 189.382f, 97.375f, 193.455f, 98.4f)
                verticalLineTo(109.675f)
                curveTo(189.382f, 108.137f, 185.267f, 106.984f, 181.109f, 106.216f)
                curveTo(176.952f, 105.447f, 172.582f, 105.062f, 168.0f, 105.062f)
                curveTo(161.552f, 105.062f, 155.358f, 105.831f, 149.418f, 107.369f)
                curveTo(143.479f, 108.906f, 137.794f, 111.212f, 132.364f, 114.287f)
                close()
                moveTo(132.364f, 86.1f)
                verticalLineTo(73.8f)
                curveTo(137.964f, 71.408f, 143.691f, 69.615f, 149.545f, 68.419f)
                curveTo(155.4f, 67.223f, 161.552f, 66.625f, 168.0f, 66.625f)
                curveTo(172.412f, 66.625f, 176.739f, 66.967f, 180.982f, 67.65f)
                curveTo(185.224f, 68.333f, 189.382f, 69.188f, 193.455f, 70.213f)
                verticalLineTo(81.488f)
                curveTo(189.382f, 79.95f, 185.267f, 78.797f, 181.109f, 78.028f)
                curveTo(176.952f, 77.259f, 172.582f, 76.875f, 168.0f, 76.875f)
                curveTo(161.552f, 76.875f, 155.358f, 77.687f, 149.418f, 79.309f)
                curveTo(143.479f, 80.932f, 137.794f, 83.196f, 132.364f, 86.1f)
                close()
                moveTo(120.145f, 140.938f)
                curveTo(128.63f, 136.667f, 136.945f, 133.464f, 145.091f, 131.328f)
                curveTo(153.236f, 129.193f, 161.891f, 128.125f, 171.055f, 128.125f)
                curveTo(177.503f, 128.125f, 184.164f, 128.637f, 191.036f, 129.662f)
                curveTo(197.909f, 130.687f, 203.806f, 132.054f, 208.727f, 133.762f)
                verticalLineTo(23.831f)
                curveTo(202.958f, 20.927f, 196.864f, 18.792f, 190.445f, 17.425f)
                curveTo(184.027f, 16.058f, 177.563f, 15.375f, 171.055f, 15.375f)
                curveTo(161.891f, 15.375f, 153.024f, 16.784f, 144.455f, 19.603f)
                curveTo(135.885f, 22.422f, 127.782f, 26.394f, 120.145f, 31.519f)
                verticalLineTo(140.938f)
                close()
                moveTo(112.509f, 164.0f)
                curveTo(103.855f, 157.508f, 94.436f, 152.511f, 84.255f, 149.009f)
                curveTo(74.073f, 145.507f, 63.636f, 143.756f, 52.945f, 143.756f)
                curveTo(46.745f, 143.756f, 40.656f, 144.525f, 34.677f, 146.062f)
                curveTo(28.698f, 147.6f, 22.739f, 149.479f, 16.8f, 151.7f)
                curveTo(12.88f, 153.579f, 9.1f, 153.323f, 5.46f, 150.931f)
                curveTo(1.82f, 148.54f, 0.0f, 145.123f, 0.0f, 140.681f)
                verticalLineTo(22.038f)
                curveTo(0.0f, 19.475f, 0.594f, 17.126f, 1.782f, 14.991f)
                curveTo(2.97f, 12.855f, 4.752f, 11.19f, 7.127f, 9.994f)
                curveTo(14.255f, 6.577f, 21.679f, 4.057f, 29.4f, 2.434f)
                curveTo(37.121f, 0.811f, 44.97f, 0.0f, 52.945f, 0.0f)
                curveTo(63.636f, 0.0f, 74.03f, 1.452f, 84.127f, 4.356f)
                curveTo(94.224f, 7.26f, 103.685f, 11.702f, 112.509f, 17.681f)
                curveTo(121.164f, 11.702f, 130.455f, 7.26f, 140.382f, 4.356f)
                curveTo(150.309f, 1.452f, 160.533f, 0.0f, 171.055f, 0.0f)
                curveTo(179.061f, 0.0f, 186.874f, 0.811f, 194.495f, 2.434f)
                curveTo(202.117f, 4.057f, 209.491f, 6.577f, 216.618f, 9.994f)
                curveTo(218.994f, 11.19f, 220.818f, 12.855f, 222.091f, 14.991f)
                curveTo(223.364f, 17.126f, 224.0f, 19.475f, 224.0f, 22.038f)
                verticalLineTo(140.681f)
                curveTo(224.0f, 145.446f, 222.091f, 149.072f, 218.273f, 151.558f)
                curveTo(214.455f, 154.044f, 210.679f, 154.092f, 206.945f, 151.7f)
                curveTo(201.176f, 149.308f, 195.302f, 147.386f, 189.323f, 145.934f)
                curveTo(183.344f, 144.482f, 177.255f, 143.756f, 171.055f, 143.756f)
                curveTo(160.364f, 143.756f, 150.097f, 145.55f, 140.255f, 149.137f)
                curveTo(130.412f, 152.725f, 121.164f, 157.679f, 112.509f, 164.0f)
                close()
            }
        }
            .build()
        return guide!!
    }

private var guide: ImageVector? = null
