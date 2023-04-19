package learn.git

import androidx.compose.ui.window.application
import learn.git.di.initKoin
import learn.git.ui.MainDesktop

fun main() = application {
    initKoin()
    MainDesktop()
}
