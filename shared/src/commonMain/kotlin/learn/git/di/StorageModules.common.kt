package learn.git.di

import learn.git.core.storage.di.platformStorageModule
import learn.git.core.storage.di.storageModule
import org.koin.core.module.Module

internal val storageModules: Array<Module> = arrayOf(
    platformStorageModule,
    storageModule,
)
