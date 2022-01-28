package retro.server.model

data class CreateSessionDetail(
    val name: String,
    val description: String,
    val columns: List<CreateColumnDetail>,
    val highlightColor: String
)

data class CreateColumnDetail(
    val name: String,
    val color: String
)