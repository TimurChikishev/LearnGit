package learn.git.core.storage.di

import learn.git.core.storage.utils.DATA_STORE_FILE_NAME
import learn.git.core.storage.utils.createDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformStorageModule: Module = module {
    factory {
        createDataStore(
            producePath = { androidContext().filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath }
        )
    }
}
