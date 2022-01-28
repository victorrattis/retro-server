package retro.server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import retro.server.model.CreateMeetingDetail
import retro.server.model.MeetingResponse
import retro.server.repository.MeetingRepository

@RestController
class MeetingController {
    @Autowired
    lateinit var meetingRepository: MeetingRepository;

    @GetMapping("/meeting")
    fun getMeetings(): ResponseEntity<List<MeetingResponse>> {
        return ResponseEntity.ok(meetingRepository.getMeetings())
    }

    @PostMapping("/meeting")
    fun createMeeting(@RequestBody meeting: CreateMeetingDetail): ResponseEntity<Boolean> {
        return ResponseEntity.ok(meetingRepository.createMeeting(meeting))
    }
}