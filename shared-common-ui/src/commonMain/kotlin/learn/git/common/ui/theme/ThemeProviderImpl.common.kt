package learn.git.common.ui.theme

internal expect class ThemeProviderImpl : ThemeProvider {
    override fun getCurrentThemeColors(): Colors
}
