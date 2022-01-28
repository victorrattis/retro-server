package retro.server.model

data class MeetingResponse(
    val id: String,
    val title: String,
    val startDate: Int,
    val endDate: Int,
    val local: String,
    val sessions: Int,
    val people: Int
)