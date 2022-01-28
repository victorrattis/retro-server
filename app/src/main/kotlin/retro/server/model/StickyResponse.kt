package retro.server.model

data class StickyResponse(
    val id: String,
    val content: String,
    val columnName: String,
    val userName: String,
    val sessionId: String
)
