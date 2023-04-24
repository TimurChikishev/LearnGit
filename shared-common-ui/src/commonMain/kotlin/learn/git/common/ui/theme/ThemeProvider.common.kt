package learn.git.common.ui.theme

interface ThemeProvider {

    val isDarkTheme: Boolean

    fun getCurrentThemeColors(): Colors
}
