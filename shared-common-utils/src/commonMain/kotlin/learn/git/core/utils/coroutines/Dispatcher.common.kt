package learn.git.core.utils.coroutines

import kotlinx.coroutines.CoroutineDispatcher

expect val ioDispatcher: CoroutineDispatcher
expect val mainDispatcher: CoroutineDispatcher
