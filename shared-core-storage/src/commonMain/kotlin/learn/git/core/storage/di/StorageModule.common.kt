package learn.git.core.storage.di

import learn.git.core.storage.preference.settings.SettingStorageImpl
import learn.git.core.storage.preference.settings.SettingsStorage
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformStorageModule: Module

val storageModule: Module = module {
    factory<SettingsStorage> {
        SettingStorageImpl(datastore = get())
    }
}
