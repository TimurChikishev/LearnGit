package learn.git.common.graph.walker

import learn.git.common.graph.tree.TreeNode

data class WalkerNodeData<T>(
    var ancestor: TreeNode<T>,
    var thread: TreeNode<T>? = null,
    var number: Int = 0,
    var depth: Int = 0,
    var prelim: Double = 0.toDouble(),
    var modifier: Double = 0.toDouble(),
    var shift: Double = 0.toDouble(),
    var change: Double = 0.toDouble(),
)
