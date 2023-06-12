package learn.git.common.graph.tree

import learn.git.core.utils.common.requiredNotNull

fun <T> TreeNode<T>.sortByLevel(): List<TreeNode<T>> = map { it }.sortedBy { it.depth() }

fun <T> TreeNode<T>.filterByLevel(level: Int): List<TreeNode<T>> =
    map { it }.filter { it.depth() == level }

fun <T> TreeNode<T>.groupByLevel(): Map<Int, List<TreeNode<T>>> = map { it }.groupBy { it.depth() }

fun <T> TreeNode<T>.findMaxLevelSize(): Int = groupByLevel().maxOf { it.value.size }

fun <T> TreeNode<T>.levelSize(level: Int): Int = filterByLevel(level).size

val <T> TreeNode<T>.hasLeftSibling: Boolean
    get() {
        val p = this.parent ?: return false
        val nodeIndex = p.children.indexOf(this)
        return nodeIndex > 0
    }

val <T> TreeNode<T>.hasRightSibling: Boolean
    get() {
        val children = this.parent?.children ?: return false
        val nodeIndex = children.indexOf(this)
        return nodeIndex < children.size - 1
    }

val <T> TreeNode<T>.leftSibling: TreeNode<T>?
    get() {
        if (!hasLeftSibling) return null
        val children = parent?.children.requiredNotNull()
        val nodeIndex = children.indexOf(this)
        return children[nodeIndex - 1]
    }

val <T> TreeNode<T>.root: TreeNode<T>
    get() = parent?.root ?: this

val <T> TreeNode<T>.rightSibling: TreeNode<T>?
    get() {
        if (!hasLeftSibling) return null
        val children = parent?.children.requiredNotNull()
        val nodeIndex = children.indexOf(this)
        return children[nodeIndex + 1]
    }
