package learn.git.common.ui.theme

import android.content.Context
import android.content.res.Configuration

internal actual class ThemeProviderImpl(private val context: Context) : ThemeProvider {

    override val isDarkTheme: Boolean
        get() {
            val uiMode = context.resources.configuration.uiMode
            return (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
        }

    actual override fun getCurrentThemeColors(): Colors = if (isDarkTheme) Colors.Dark else Colors.Light
}
