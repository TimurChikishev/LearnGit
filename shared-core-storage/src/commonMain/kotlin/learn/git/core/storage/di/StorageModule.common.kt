package learn.git.core.storage.di

import learn.git.core.storage.data.settings.SettingStorageImpl
import learn.git.core.storage.data.settings.SettingsStorage
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformStorageModule: Module

val storageModule: Module = module {
    factory<SettingsStorage> {
        SettingStorageImpl(datastore = get())
    }
}
