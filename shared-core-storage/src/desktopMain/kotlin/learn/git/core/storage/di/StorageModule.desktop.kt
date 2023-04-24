package learn.git.core.storage.di

import java.io.File
import learn.git.core.storage.utils.DATA_STORE_FILE_NAME
import learn.git.core.storage.utils.createDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformStorageModule: Module = module {
    single {
        createDataStore(
            producePath = {
                val patch = File(".").absolutePath + "/$DATA_STORE_FILE_NAME"
                patch
            }
        )
    }
}
