package retro.server.model

data class CreateMeetingDetail(
    val title: String,
    val startDate: Int,
    val endDate: Int,
    val local: String,
    val sessions: List<CreateSessionDetail>
)
