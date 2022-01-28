package retro.server.model

data class SessionResponse(
    val meetingId: String,
    val name: String,
    val description: String,
    val columns: List<CreateColumnDetail>,
    val highlight: String
)
