package learn.git.common.graph.tree

fun <T> TreeNode<T>.groupByLevel(): Map<Int, List<TreeNode<T>>> = map { it }.groupBy { it.depth() }

fun <T> TreeNode<T>.findMaxLevelSize(): Int = groupByLevel().maxOf { it.value.size }
