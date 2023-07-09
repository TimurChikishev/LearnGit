package learn.git.common.graph.tree

import learn.git.common.graph.models.Point

open class TreeNode<T>(val value: T) : Iterable<TreeNode<T>> {

    private var _parent: TreeNode<T>? = null
    val parent: TreeNode<T>?
        get() = _parent

    private val _children = mutableListOf<TreeNode<T>>()
    val children: List<TreeNode<T>>
        get() = _children

    private var _position: Point = Point(x = 0f, y = 0f)
    val position: Point
        get() = _position

    private var _prelim = 0F
    val prelim: Float
        get() = _prelim

    private var _modifier = 0F
    val modifier: Float
        get() = _modifier

    var leftNeighbor: TreeNode<T>? = null
    var rightNeighbor: TreeNode<T>? = null

    fun setPosition(position: Point) {
        _position = position
    }

    fun setPosition(x: Float, y: Float) {
        _position = Point(x = x, y = y)
    }

    fun setPrelim(prelim: Float) {
        _prelim = prelim
    }

    fun setModifier(modifier: Float) {
        _modifier = modifier
    }

    fun addChild(child: TreeNode<T>) {
        child._parent = this
        _children.add(child)
    }

    fun removeChild(child: TreeNode<T>): Boolean {
        println(child.value)
        val removed = child._parent?._children?.remove(child)
        child._parent = null
        return removed ?: false
    }

    fun nodeCount(): Int {
        if (_children.isEmpty()) {
            return 0
        }
        return _children.size +
            _children.sumOf { it.nodeCount() }
    }

    fun height(): Int {
        val childrenMaxDepth = _children.map { it.height() }
            .maxOrNull()
            ?: -1 // -1 because this method counts nodes, and edges are always one less then nodes.
        return childrenMaxDepth + 1
    }

    fun depth(): Int {
        var depth = 0
        var tempParent = parent

        while (tempParent != null) {
            depth++
            tempParent = tempParent.parent
        }
        return depth
    }

    fun clear() {
        _parent = null
        _children.forEach { it.clear() }
        _children.clear()
    }

    override fun toString(): String {
        return value.toString()
    }

    fun prettyString(): String {
        val stringBuilder = StringBuilder()
        print(stringBuilder, "", "")
        return stringBuilder.toString()
    }

    private fun print(stringBuilder: StringBuilder, prefix: String, childrenPrefix: String) {
        stringBuilder.append(prefix)
        stringBuilder.append(value)
        stringBuilder.append('\n')
        val childIterator = _children.iterator()
        while (childIterator.hasNext()) {
            val node = childIterator.next()
            if (childIterator.hasNext()) {
                node.print(stringBuilder, "$childrenPrefix├── ", "$childrenPrefix│   ")
            } else {
                node.print(stringBuilder, "$childrenPrefix└── ", "$childrenPrefix    ")
            }
        }
    }

    override fun iterator(): Iterator<TreeNode<T>> = TreeIterator(this)
}
