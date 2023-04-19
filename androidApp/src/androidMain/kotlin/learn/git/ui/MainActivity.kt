package learn.git.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import learn.git.MainAndroid
import learn.git.common.ui.theme.ThemeProvider
import learn.git.common.ui.utils.TransparentSystemBars
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val themeProvider by inject<ThemeProvider>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            TransparentSystemBars(darkIcons = themeProvider.isDarkTheme.not())
            MainAndroid()
        }
    }
}
