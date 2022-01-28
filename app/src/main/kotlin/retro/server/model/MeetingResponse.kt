package retro.server.model

data class MeetingResponse(
    val id: String,
    val title: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val local: String,
    val sessions: Int,
    val people: Int
)