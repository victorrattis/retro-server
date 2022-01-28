package retro.server.repository

import org.springframework.stereotype.Component
import retro.server.model.CreateColumnDetail
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
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

    fun getData(): MutableList<Meeting> = meetings

    fun createMeeting(name: String, description: String, start: String, end: String, local: String): String {
        val meetingId = UUID.randomUUID().toString();
        meetings.add(Meeting(
            meetingId,
            name,
            description,
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

const val highlightColor1 = "87369B"
const val highlightColor2 = "F3C152"

const val color1 = "4A619C"
const val color2 = "2C9FDC"
const val color3 = "E0857F"
const val color4 = "F3C152"
const val color5 = "7985BE"

fun initData(meetingDataSource: InternalMeetingDataSource) {
    val starfishColumns = listOf(
        CreateColumnDetail("Less", color1),
        CreateColumnDetail("More", color2),
        CreateColumnDetail("Start", color3),
        CreateColumnDetail("Stop", color4),
        CreateColumnDetail("Keep", color5)
    )

    val gainPleasureColumns = listOf(
        CreateColumnDetail("Loss & Pleasure", color1),
        CreateColumnDetail("Gain & Pleasure", color2),
        CreateColumnDetail("Loss & Pain", color4),
        CreateColumnDetail("Gain & Pain", color5)
    )

    meetingDataSource.createMeeting("Retrospective", "Bi-weekly meeting to discuss pain points, celebrate achievements and define common  actions to all team","23-01-2022", "23-01-2022", "CESAR School").also { meetingId: String ->
        meetingDataSource.createSession(meetingId, "Starfish", "To foster the thinking around practices and the value the team from it", starfishColumns, highlightColor1).also { sessionId ->
            meetingDataSource.createSticky(meetingId, sessionId, "More 1", "More", "Victor")
            meetingDataSource.createSticky(meetingId, sessionId, "Keep 1", "More", "Victor")
            meetingDataSource.createSticky(meetingId, sessionId, "Stop 1", "More", "Hugo")
        }
        meetingDataSource.createSession(meetingId, "Gain & Pleasure", "Talk about all work related things and how does it affects each participant", gainPleasureColumns, highlightColor2)
    }

    meetingDataSource.createMeeting("Retrospective", "Bi-weekly meeting to discuss pain points, celebrate achievements and define common  actions to all team","09-01-2022", "09-01-2022", "CESAR School").also { meetingId: String ->
        meetingDataSource.createSession(meetingId, "Starfish", "To foster the thinking around practices and the value the team from it", starfishColumns, highlightColor1)
        meetingDataSource.createSession(meetingId, "Gain & Pleasure", "...", gainPleasureColumns, highlightColor2)
    }
}

