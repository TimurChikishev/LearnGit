package learn.git.common.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun <T> rememberBlock(block: () -> T) = remember { block }

@Composable
fun <P, T> rememberBlockWithParams(block: (P) -> T) = remember { block }

@Composable
fun <P1, P2, T> rememberBlockWithParams(block: (P1, P2) -> T) = remember { block }