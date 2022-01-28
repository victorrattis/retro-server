package retro.server.repository

import org.springframework.stereotype.Component
import retro.server.model.CreateColumnDetail
import java.util.*

object MemoryMeetingDataSource {
    var meetingDataSource: InternalMeetingDataSource = InternalMeetingDataSource();
    init {
        initData(meetingDataSource)
    }
}

@Component
class InternalMeetingDataSource {
    private val meetings: MutableList<Meeting> = mutableListOf()

    public fun getData(): List<Meeting> = meetings

    fun createMeeting(name: String, start: Int, end: Int, local: String): String {
        val meetingId = UUID.randomUUID().toString();
        meetings.add(Meeting(
            meetingId,
            name,
            start,
            end,
            local
        ))
        return meetingId
    }

    fun createSession(meetingId: String, name: String, description: String, columns: List<CreateColumnDetail>, highlight: String = ""): String {
        val sessionId = UUID.randomUUID().toString();
        meetings.find { it.id == meetingId }?.sessions?.add(Session(sessionId, meetingId, name, description, columns, highlight))
        return sessionId
    }

    fun createSticky(meetingId: String, sessionId: String, content: String, columnName: String, userName: String) {
        val stickyId = UUID.randomUUID().toString();
        meetings.find { it.id == meetingId }
            ?.sessions?.find { it.id == sessionId }
            ?.stickies?.add(Sticky(
                stickyId,
                content,
                columnName,
                userName,
                sessionId
            ))
    }

    override fun toString(): String {
        return meetings.toString()
    }
}


fun initData(meetingDataSource: InternalMeetingDataSource) {
    val starfishColumns = listOf(
        CreateColumnDetail("Less", ""),
        CreateColumnDetail("More", ""),
        CreateColumnDetail("Start", ""),
        CreateColumnDetail("Stop", ""),
        CreateColumnDetail("Keep", "")
    )

    val gainPleasureColumns = listOf(
        CreateColumnDetail("Loss & Pleasure", ""),
        CreateColumnDetail("Gain & Pleasure", ""),
        CreateColumnDetail("Loss & Pain", ""),
        CreateColumnDetail("Gain & Pain", "")
    )

    meetingDataSource.createMeeting("Retrospective", 0, 0, "CESAR School").also { meetingId: String ->
        meetingDataSource.createSession(meetingId, "Starfish", "...", starfishColumns, "#").also { sessionId ->
            meetingDataSource.createSticky(meetingId, sessionId, "More 1", "More", "Test")
        }
        meetingDataSource.createSession(meetingId, "Gain & Pleasure", "...", gainPleasureColumns, "#")
    }

    meetingDataSource.createMeeting("Retrospective", 0, 0, "CESAR School").also { meetingId: String ->
        meetingDataSource.createSession(meetingId, "Starfish", "...", starfishColumns, "#")
        meetingDataSource.createSession(meetingId, "Gain & Pleasure", "...", gainPleasureColumns, "#")
    }
}

