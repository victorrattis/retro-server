package retro.server.repository

import retro.server.model.CreateColumnDetail

data class Session(
    val id: String,
    val meetingId: String,
    val name: String,
    val description: String,
    val columns: List<CreateColumnDetail>,
    val highlight: String,
    var stickies: MutableList<Sticky> = mutableListOf()
)