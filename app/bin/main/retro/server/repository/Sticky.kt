package retro.server.repository

data class Sticky(
    val id: String,
    val content: String,
    val columnName: String,
    val userName: String,
    val sessionId: String
)
