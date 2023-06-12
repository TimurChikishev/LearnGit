package learn.git.common.graph.tree

import learn.git.common.graph.stack.Stack

class TreeIterator<T>(root: TreeNode<T>) : Iterator<TreeNode<T>> {

    private val stack = Stack<TreeNode<T>>()

    init {
        stack.push(root)
    }

    override fun hasNext(): Boolean = !stack.isEmpty()

    override fun next(): TreeNode<T> {
        val node = stack.pop()
        node.children
            .asReversed()
            .forEach { stack.push(it) }
        return node
    }
}
