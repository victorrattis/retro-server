package retro.server.repository

import org.springframework.stereotype.Component
import retro.server.model.*
import java.util.*

@Component
class MeetingRepository {
    fun createMeeting(meeting: CreateMeetingDetail): Boolean? {
        MemoryMeetingDataSource.meetingDataSource.getData().add(Meeting(
            UUID.randomUUID().toString(),
            meeting.title,
            meeting.description,
            meeting.startDate,
            meeting.endDate,
            meeting.local,
            mutableListOf(),
            mutableListOf()
        ))
        return true
    }

    fun getMeetings(): List<MeetingResponse>? {
        return MemoryMeetingDataSource.meetingDataSource.getData().map { meeting ->
            MeetingResponse(
                meeting.id,
                meeting.title,
                meeting.description,
                meeting.startDate,
                meeting.endDate,
                meeting.local,
                meeting.sessions.size,
                getPeopleNumber(meeting)
            )
        }
    }

    fun getSessions(meetingId: String): List<SessionResponse>? {
        return MemoryMeetingDataSource.meetingDataSource.getData()
            .find { meeting -> meeting.id == meetingId }
            ?.sessions?.map { session -> SessionResponse(
                session.id,
                meetingId,
                session.name,
                session.description,
                session.columns,
                session.highlight
            ) }
    }

    fun createSession(meetingId: String, session: CreateSessionDetail): Boolean? {
        MemoryMeetingDataSource.meetingDataSource.getData()
            .find { meeting -> meeting.id == meetingId }
            ?.sessions?.add(Session(
                UUID.randomUUID().toString(),
                meetingId,
                session.name,
                session.description,
                session.columns,
                session.highlightColor
            ))
        return true
    }

    fun getStickies(meetingId: String, sessionId: String): List<StickyResponse>? =
        MemoryMeetingDataSource.meetingDataSource.getData()
            .find { meeting -> meeting.id == meetingId }
            ?.sessions?.find { session -> session.id == sessionId }
            ?.stickies?.map { sticky -> StickyResponse(
                sticky.id,
                sticky.content,
                sticky.columnName,
                sticky.userName,
                sticky.sessionId
            ) }

    fun createSticky(createStickyDetail: CreateStickyDetail): Boolean {
        MemoryMeetingDataSource.meetingDataSource.getData()
            .find { meeting -> meeting.id == createStickyDetail.meetingId }
            ?.sessions?.find { session -> session.id == createStickyDetail.sessionId }
            ?.stickies?.add(Sticky(
                UUID.randomUUID().toString(),
                createStickyDetail.content,
                createStickyDetail.columnName,
                createStickyDetail.userName,
                createStickyDetail.sessionId
            ))
        return true
    }

    private fun getPeopleNumber(meeting: Meeting): Int = mutableListOf<Sticky>()
        .apply { meeting.sessions.forEach { session -> addAll(session.stickies) } }
        .groupBy { it.userName }.size
}