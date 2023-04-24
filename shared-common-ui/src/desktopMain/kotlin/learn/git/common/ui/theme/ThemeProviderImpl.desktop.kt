package learn.git.common.ui.theme

import org.jetbrains.skiko.SystemTheme
import org.jetbrains.skiko.currentSystemTheme

internal actual class ThemeProviderImpl : ThemeProvider {

    override val isDarkTheme: Boolean
        get() = currentSystemTheme == SystemTheme.DARK

    actual override fun getCurrentThemeColors(): Colors = if (isDarkTheme) Colors.Dark else Colors.Light
}
