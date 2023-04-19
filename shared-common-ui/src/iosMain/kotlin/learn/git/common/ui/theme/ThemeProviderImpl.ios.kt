package learn.git.common.ui.theme

import platform.UIKit.UITraitCollection
import platform.UIKit.UIUserInterfaceStyle
import platform.UIKit.currentTraitCollection

internal actual class ThemeProviderImpl : ThemeProvider {

    override val isDarkTheme: Boolean
        get() {
            return UITraitCollection.currentTraitCollection.userInterfaceStyle ==
                UIUserInterfaceStyle.UIUserInterfaceStyleDark
        }

    actual override fun getCurrentThemeColors(): Colors = if (isDarkTheme) Colors.Dark else Colors.Light
}
