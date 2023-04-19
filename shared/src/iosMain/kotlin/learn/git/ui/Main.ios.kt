package learn.git.ui

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

@Suppress("FunctionName", "unused")
fun MainViewController(): UIViewController =
    ComposeUIViewController {
        Main()
    }
