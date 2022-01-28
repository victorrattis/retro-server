package retro.server.model

data class CreateMeetingDetail(
    val title: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val local: String,
    val sessions: List<CreateSessionDetail>
)
