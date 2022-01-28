package retro.server.repository

data class Meeting(
    val id: String,
    val title: String,
    val startDate: Int,
    val endDate: Int,
    val local: String,
    var sessions: MutableList<Session> = mutableListOf(),
    var stickies: MutableList<Sticky> = mutableListOf()
)