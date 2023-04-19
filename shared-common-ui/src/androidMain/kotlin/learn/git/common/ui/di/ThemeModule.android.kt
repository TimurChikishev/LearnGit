package learn.git.common.ui.di

import learn.git.common.ui.theme.ThemeProvider
import learn.git.common.ui.theme.ThemeProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val themeModule = module {
    factory<ThemeProvider> {
        ThemeProviderImpl(
            context = androidContext()
        )
    }
}
