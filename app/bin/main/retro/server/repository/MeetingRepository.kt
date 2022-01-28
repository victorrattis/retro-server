package retro.server.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import retro.server.model.CreateMeetingDetail
import retro.server.model.MeetingResponse
import java.util.*

@Component
class MeetingRepository {

    @Autowired
    lateinit var meetingRepository: InternalMeetingDataSource

    fun createMeeting(meeting: CreateMeetingDetail): Boolean? {
        return false;
    }

    fun getMeetings(): List<MeetingResponse>? {
        return listOf(
            MeetingResponse(UUID.randomUUID().toString(), "Retrospective",  0, 0, "Local", 1, 16),

            MeetingResponse(UUID.randomUUID().toString(), "Retrospective",  0, 0, "Local", 2, 16)
        )
    }
}