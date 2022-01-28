package retro.server.repository

data class Meeting(
    val id: String,
    val title: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val local: String,
    var sessions: MutableList<Session> = mutableListOf(),
    var stickies: MutableList<Sticky> = mutableListOf()
)