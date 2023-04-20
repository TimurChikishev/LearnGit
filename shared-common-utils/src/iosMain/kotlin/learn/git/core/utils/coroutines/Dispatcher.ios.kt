package learn.git.core.utils.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

actual val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
actual val mainDispatcher: CoroutineDispatcher = Dispatchers.Main
