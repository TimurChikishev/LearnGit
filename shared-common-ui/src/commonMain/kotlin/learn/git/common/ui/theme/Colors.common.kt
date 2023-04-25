package learn.git.common.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ColorResource
import learn.git.res.MR
import dev.icerock.moko.graphics.Color as KColor

fun KColor.asCompose(): Color = Color(color = argb.toInt())
fun ColorResource.Single.asCompose(): Color = color.asCompose()

enum class Colors(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer: Color,
    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,
    val inverseSurface: Color,
    val inverseOnSurface: Color,
    val outline: Color,
    val outlineVariant: Color,
    val surfaceTint: Color,
    val inversePrimary: Color,
    val scrim: Color,
) {
    Light(
        primary = MR.colors.primaryLight.asCompose(),
        onPrimary = MR.colors.onPrimaryLight.asCompose(),
        primaryContainer = MR.colors.primaryContainerLight.asCompose(),
        onPrimaryContainer = MR.colors.onPrimaryContainerLight.asCompose(),
        inversePrimary = MR.colors.inversePrimaryLight.asCompose(),

        secondary = MR.colors.secondaryLight.asCompose(),
        onSecondary = MR.colors.onSecondaryLight.asCompose(),
        secondaryContainer = MR.colors.secondaryContainerLight.asCompose(),
        onSecondaryContainer = MR.colors.onSecondaryContainerLight.asCompose(),

        tertiary = MR.colors.tertiaryLight.asCompose(),
        onTertiary = MR.colors.onTertiaryLight.asCompose(),
        tertiaryContainer = MR.colors.tertiaryContainerLight.asCompose(),
        onTertiaryContainer = MR.colors.onTertiaryContainerLight.asCompose(),

        error = MR.colors.errorLight.asCompose(),
        onError = MR.colors.onErrorLight.asCompose(),
        errorContainer = MR.colors.errorContainerLight.asCompose(),
        onErrorContainer = MR.colors.onErrorContainerLight.asCompose(),

        background = MR.colors.backgroundLight.asCompose(),
        onBackground = MR.colors.onBackgroundLight.asCompose(),

        surface = MR.colors.surfaceLight.asCompose(),
        onSurface = MR.colors.onSurfaceLight.asCompose(),
        surfaceVariant = MR.colors.surfaceVariantLight.asCompose(),
        onSurfaceVariant = MR.colors.onSurfaceVariantLight.asCompose(),
        inverseSurface = MR.colors.inverseSurfaceLight.asCompose(),
        inverseOnSurface = MR.colors.inverseOnSurfaceLight.asCompose(),
        surfaceTint = MR.colors.surfaceTintLight.asCompose(),

        outline = MR.colors.outlineLight.asCompose(),
        outlineVariant = MR.colors.outlineVariantLight.asCompose(),

        scrim = MR.colors.white.asCompose(),
    ),
    Dark(
        primary = MR.colors.primaryDark.asCompose(),
        onPrimary = MR.colors.onPrimaryDark.asCompose(),
        primaryContainer = MR.colors.primaryContainerDark.asCompose(),
        onPrimaryContainer = MR.colors.onPrimaryContainerDark.asCompose(),
        inversePrimary = MR.colors.inversePrimaryDark.asCompose(),

        secondary = MR.colors.secondaryDark.asCompose(),
        onSecondary = MR.colors.onSecondaryDark.asCompose(),
        secondaryContainer = MR.colors.secondaryContainerDark.asCompose(),
        onSecondaryContainer = MR.colors.onSecondaryContainerDark.asCompose(),

        tertiary = MR.colors.tertiaryDark.asCompose(),
        onTertiary = MR.colors.onTertiaryDark.asCompose(),
        tertiaryContainer = MR.colors.tertiaryContainerDark.asCompose(),
        onTertiaryContainer = MR.colors.onTertiaryContainerDark.asCompose(),

        error = MR.colors.errorDark.asCompose(),
        onError = MR.colors.onErrorDark.asCompose(),
        errorContainer = MR.colors.errorContainerDark.asCompose(),
        onErrorContainer = MR.colors.onErrorContainerDark.asCompose(),

        background = MR.colors.backgroundDark.asCompose(),
        onBackground = MR.colors.onBackgroundDark.asCompose(),

        surface = MR.colors.surfaceDark.asCompose(),
        onSurface = MR.colors.onSurfaceDark.asCompose(),
        surfaceVariant = MR.colors.surfaceVariantDark.asCompose(),
        onSurfaceVariant = MR.colors.onSurfaceVariantDark.asCompose(),
        inverseSurface = MR.colors.inverseSurfaceDark.asCompose(),
        inverseOnSurface = MR.colors.inverseOnSurfaceDark.asCompose(),
        surfaceTint = MR.colors.surfaceTintDark.asCompose(),

        outline = MR.colors.outlineDark.asCompose(),
        outlineVariant = MR.colors.outlineVariantDark.asCompose(),

        scrim = MR.colors.black.asCompose(),
    );

    val colorScheme: ColorScheme
        get() = ColorScheme(
            primary = primary,
            onPrimary = onPrimary,
            primaryContainer = primaryContainer,
            onPrimaryContainer = onPrimaryContainer,
            secondary = secondary,
            onSecondary = onSecondary,
            secondaryContainer = secondaryContainer,
            onSecondaryContainer = onSecondaryContainer,
            tertiary = tertiary,
            onTertiary = onTertiary,
            tertiaryContainer = tertiaryContainer,
            onTertiaryContainer = onTertiaryContainer,
            error = error,
            onError = onError,
            errorContainer = errorContainer,
            onErrorContainer = onErrorContainer,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            surfaceVariant = surfaceVariant,
            onSurfaceVariant = onSurfaceVariant,
            inverseSurface = inverseSurface,
            inverseOnSurface = inverseOnSurface,
            outline = outline,
            outlineVariant = outlineVariant,
            surfaceTint = surfaceTint,
            inversePrimary = inversePrimary,
            scrim = scrim,
        )
}
