package learn.git.common.graph.stack

class Stack<T> {
    private val elements: MutableList<T> = mutableListOf()

    fun isEmpty() = elements.isEmpty()

    fun count() = elements.size

    fun push(item: T) = elements.add(item)

    fun pop(): T {
        val item = elements.lastOrNull() ?: error("Error pop()")
        if (!isEmpty()) {
            elements.removeAt(elements.size - 1)
        }
        return item
    }

    fun peek(): T? = elements.lastOrNull()

    override fun toString(): String = elements.toString()
}

fun <T> Stack<T>.push(items: Collection<T>) = items.forEach { this.push(it) }
