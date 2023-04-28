package learn.git.core.utils.common

interface Mapper<From, To> {
    fun map(item: From): To
    fun map(list: List<From>): List<To> {
        return list.map { map(it) }
    }
}
