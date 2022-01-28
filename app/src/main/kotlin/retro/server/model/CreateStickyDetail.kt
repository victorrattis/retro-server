package retro.server.model

data class CreateStickyDetail(
    val meetingId: String,
    val sessionId: String,
    val content: String,
    val columnName: String,
    val userName: String,
)
