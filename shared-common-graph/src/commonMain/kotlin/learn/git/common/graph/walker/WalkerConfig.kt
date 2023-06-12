package learn.git.common.graph.walker

data class WalkerConfig(
    val siblingSeparation: Int,
    val levelSeparation: Int,
    val subtreeSeparation: Int,
    val nodeSize: Int
)
