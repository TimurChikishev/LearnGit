package learn.git.common.graph.walker

import learn.git.common.graph.models.Point
import learn.git.common.graph.tree.TreeNode
import learn.git.core.utils.common.requiredNotNull

/**
 * A Node-Positioning Algorithm for General Trees
 * https://drive.google.com/file/d/1uK4YxUSxDkmPseWKFPbv-8Qfb_qtJ5Z4/view?usp=sharing
 */
class Walker<T>(private val config: WalkerConfig) {

    private val prevLevelNode: MutableMap<Int, TreeNode<T>> = HashMap()

    private val <T> TreeNode<T>.hasLeftSibling: Boolean
        get() {
            val p = this.parent ?: return false
            val nodeIndex = p.children.indexOf(this)
            return nodeIndex > 0
        }

    private val <T> TreeNode<T>.leftSibling: TreeNode<T>?
        get() {
            if (!hasLeftSibling) return null
            val children = parent?.children.requiredNotNull()
            val nodeIndex = children.indexOf(this)
            return children[nodeIndex - 1]
        }

    private val <T> TreeNode<T>.isLeaf: Boolean
        get() = children.isEmpty()

    private val TreeNode<T>.firstChild: TreeNode<T>?
        get() = children.firstOrNull()

    private val TreeNode<T>.lastChild: TreeNode<T>?
        get() = children.lastOrNull()

    private val TreeNode<T>.centerChild: Float
        get() {
            val node = this.firstChild.requiredNotNull()
            val node1 = this.lastChild.requiredNotNull()
            return node.prelim + ((node1.prelim - node.prelim) + config.nodeSize) / 2
        }

    fun positionTree(tree: TreeNode<T>, shiftX: Float, shiftY: Float) {
        firstWalk(node = tree, 0)
        secondWalk(node = tree, 0F)
        shiftPositions(
            tree = tree,
            shiftX = shiftX,
            shiftY = shiftY / 2f
        )
    }

    private fun firstWalk(node: TreeNode<T>, level: Int) {
        setNeighbors(node = node, level = level)

        if (node.isLeaf) {
            val leftSibling = node.leftSibling
            if (leftSibling != null) {
                node.setPrelim(leftSibling.prelim + config.siblingSeparation + config.nodeSize)
            } else {
                node.setPrelim(0F)
            }
        } else {
            for (child in node.children) {
                firstWalk(node = child, level = level + 1)
            }
            val midPoint = node.centerChild - (config.nodeSize / 2F)
            val leftSibling = node.leftSibling
            if (leftSibling != null) {
                node.setPrelim(leftSibling.prelim + config.nodeSize + config.siblingSeparation)
                node.setModifier(node.prelim - midPoint)
                apportion(node = node)
            } else {
                node.setPrelim(midPoint)
            }
        }
    }

    private fun secondWalk(node: TreeNode<T>, modifier: Float) {
        val depth = node.depth()

        node.setPosition(
            Point(
                x = (node.prelim + modifier),
                y = (depth * (config.nodeSize) + depth * config.levelSeparation)
            )
        )

        node.children.forEach { child ->
            secondWalk(child, modifier + node.modifier)
        }
    }

    private fun apportion(node: TreeNode<T>) {
        var firstChild = node.firstChild
        var firstChildLeftNeighbor = firstChild?.leftNeighbor

        var j = 1
        while (firstChild != null && firstChildLeftNeighbor != null) {
            var modifierSumRight = 0F
            var modifierSumLeft = 0F
            var rightAncestor = firstChild
            var leftAncestor = firstChildLeftNeighbor

            for (l in 0 until j) {
                rightAncestor = rightAncestor?.parent
                leftAncestor = leftAncestor?.parent
                modifierSumRight += rightAncestor!!.modifier
                modifierSumLeft += leftAncestor!!.modifier
            }

            var totalGap = (
                firstChildLeftNeighbor.prelim + modifierSumLeft + config.nodeSize +
                    config.subtreeSeparation
                ) - (firstChild.prelim + modifierSumRight)

            if (totalGap > 0) {
                var subtreeAux: TreeNode<T>? = node
                var numSubtrees = 0

                while (subtreeAux != null && subtreeAux != leftAncestor) {
                    subtreeAux = subtreeAux.leftSibling
                    numSubtrees++
                }

                if (subtreeAux != null) {
                    var subtreeMoveAux: TreeNode<T>? = node
                    val singleGap = if (numSubtrees != 0) totalGap / numSubtrees else totalGap

                    while (subtreeMoveAux != leftAncestor) {
                        subtreeMoveAux?.setPrelim(subtreeMoveAux.prelim.plus(totalGap))
                        subtreeMoveAux?.setModifier(subtreeMoveAux.modifier.plus(totalGap))
                        totalGap -= singleGap
                        subtreeMoveAux = subtreeMoveAux?.leftSibling
                    }
                }
            }

            j++

            firstChild = if (firstChild.children.isEmpty()) {
                node.getLeftMost(level = 0, maxLevel = j)
            } else {
                firstChild.firstChild
            }

            if (firstChild != null) {
                firstChildLeftNeighbor = firstChild.leftNeighbor
            }
        }
    }

    private fun shiftPositions(tree: TreeNode<T>, shiftX: Float, shiftY: Float) {
        tree.forEach { node ->
            node.setPosition(
                x = node.position.x + shiftX,
                y = node.position.y + shiftY
            )
        }
    }

    private fun TreeNode<T>.getLeftMost(level: Int, maxLevel: Int): TreeNode<T>? {
        if (level >= maxLevel) return this
        if (children.isEmpty()) return null

        for (child in children) {
            val leftmostDescendant = child.getLeftMost(level + 1, maxLevel)
            if (leftmostDescendant != null) {
                return leftmostDescendant
            }
        }

        return null
    }

    private fun setNeighbors(node: TreeNode<T>, level: Int) {
        node.leftNeighbor = prevLevelNode[level]
        if (node.leftNeighbor != null) {
            node.leftNeighbor?.rightNeighbor = node
        }
        prevLevelNode[level] = node
    }
}
