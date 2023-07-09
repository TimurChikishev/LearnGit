package learn.git.common.graph.walker

data class WalkerConfig(
    val siblingSeparation: Float,
    val levelSeparation: Float,
    val subtreeSeparation: Float,
    val nodeSize: Float
)
