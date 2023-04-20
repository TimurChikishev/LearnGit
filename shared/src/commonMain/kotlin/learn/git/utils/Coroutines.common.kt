package learn.git.utils

import kotlinx.coroutines.CoroutineDispatcher

expect val ioDispatcher: CoroutineDispatcher
expect val mainDispatcher: CoroutineDispatcher
